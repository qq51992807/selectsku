package com.yang.selectsku.controller.tbDetailSku;

import net.sf.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class tbGetDetailSkuId {

    public String itemId;
    public StringBuffer stringBuffer=new StringBuffer();

    public static void main(String[] args){
        tbGetDetailSkuId tbGetDetailSkuId=new tbGetDetailSkuId();
        try {
            tbGetDetailSkuId.tbGetDetailSkuMessage("635755572012");//635755572012   625457623981   633983114284
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void tbGetDetailSkuMessage(String itemId)  throws HttpException, IOException {
         Map<String,String> firstPropsMap=new HashMap<>();
         Map<String,String> secondPropsMap=new HashMap<>();
        List<String> propsPids=new ArrayList<>();
        List<String> propsNames=new ArrayList<>();
        List<String> propPathList=new ArrayList<>();
        List<String> skuNameList=new ArrayList<>();
        HttpGet httpGet = new HttpGet();
        String json=null;

// 设置参数
        try {
            httpGet.setURI(new URI("https://mdskip.taobao.com/mobile/queryH5Detail.htm?decision=sku&itemId="+itemId+"&areaId=440106020"));
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。"+e.getMessage());
        }
// 发送请求
        HttpClient client=new DefaultHttpClient();
        HttpResponse httpResponse = client.execute(httpGet);
// 获取返回的数据
        HttpEntity entity = httpResponse.getEntity();
        byte[] body = EntityUtils.toByteArray(entity);
        StatusLine sL = httpResponse.getStatusLine();
        int statusCode = sL.getStatusCode();
        if (statusCode == 200) {
            json = new String(body, "GBK");
            entity.consumeContent();
        } else {
            throw new HttpException("statusCode="+statusCode);
        }
        try {
            JSONObject jsonArray = new JSONObject(json);
            JSONObject item = new JSONObject(jsonArray.getString("item") + "");
            String title=item.getString("title");
            //skuBase
            JSONObject skuBase = new JSONObject(jsonArray.get("skuBase") + "");
            JSONArray propsArray = JSONArray.fromObject(skuBase.get("props") + "");
            if (propsArray.size()>0){
                for(int i=0;i<propsArray.size();i++) {
                    net.sf.json.JSONObject propsArray1 = (net.sf.json.JSONObject) propsArray.get(i);
                    propsPids.add(propsArray1.getString("pid"));
                    propsNames.add(propsArray1.getString("name"));
                    JSONArray values = JSONArray.fromObject(propsArray1.get("values") + "");
                    for (int j = 0; j < values.size(); j++) {
                        net.sf.json.JSONObject value = (net.sf.json.JSONObject) values.get(j);
                        if(i==0) {
                            firstPropsMap.put(value.get("vid") + "", value.get("name") + "");
                        }
                        if(i==1){
                            secondPropsMap.put(value.get("vid") + "", value.get("name") + "");
//                            System.out.println(value.get("vid") + propsArray1.getString("name") + value.get("name") + "");
                        }
                    }
                }
                JSONArray skusArray = JSONArray.fromObject(skuBase.get("skus") + "");
                if(propsPids.size()>0){
                    //拿出pid
                    for(Map.Entry<String,String> entry:firstPropsMap.entrySet()){
                        StringBuffer propPath=new StringBuffer();
                        propPath.append(propsPids.get(0)+":"+entry.getKey()+";");
                        String name="("+propsNames.get(0)+"):"+entry.getValue();
//                        System.out.println(name);
                        if(propsPids.size()==2){
                            for(Map.Entry<String,String> entry2:secondPropsMap.entrySet()) {
                                String id=propPath.toString()+propsPids.get(1) + ":" + entry2.getKey();
//                                System.out.println(propPath.toString()+propsPids.get(1) + ":" + entry2.getKey() + ";   "+name+"   ("+propsNames.get(1)+"):"+entry2.getValue());
                                for(int i=0;i<skusArray.size();i++){
                                    net.sf.json.JSONObject sku = (net.sf.json.JSONObject) skusArray.get(i);
                                    if(sku.getString("propPath").equals(id)){
                                        propPathList.add(sku.getString("skuId"));
                                        skuNameList.add(name+"   ("+propsNames.get(1)+"):"+entry2.getValue());
                                    }
                                }
                            }
                        }else{
//                            System.out.println(propPath.toString()+"----"+name);
                            for(int i=0;i<skusArray.size();i++){
                                net.sf.json.JSONObject sku = (net.sf.json.JSONObject) skusArray.get(i);
                                if(sku.getString("propPath").equals(propPath.substring(0,propPath.indexOf(";")))){
                                    propPathList.add(sku.getString("skuId"));
                                    skuNameList.add(name);
                                }
                            }
                        }

                    }
                }
                for(int i=0;i<propPathList.size();i++){
                    stringBuffer.append(skuNameList.get(i)+ "\t"+propPathList.get(i)+"\n");
                }

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
