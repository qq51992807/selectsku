package com.yang.selectsku.utils;

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
import java.util.Iterator;
import java.util.List;

public class dyGetCombIdsUtils {
    public static void main(String args[]){
        try {
            System.out.println(httpGet("https://api5-normal-act-lq.amemv.com/aweme/v1/promotion/user/promotion/list/?version_code=14.1.0&js_sdk_version=1.93.0.1&tma_jssdk_version=1.93.0.1&app_name=aweme&app_version=14.1.0&vid=A6AEF67D-0569-4416-9C0D-7370142BEF60&device_id=2304228498630093&channel=App%20Store&mcc_mnc=46000&aid=1128&screen_width=1170&openudid=701a3307965b4667cf87e21478594ac5d5ddf711&cdid=3072B043-C66C-4285-A3D5-BD7CEE4DE949&os_api=18&ac=4G&os_version=14.2&appTheme=dark&device_platform=iphone&build_number=141017&is_vcd=1&device_type=iPhone13,2&iid=2198675385226238&idfa=F47FC625-7B31-4A5E-9BA5-CCA5B42C75D9&cursor=0&sort=0&sec_user_id=MS4wLjABAAAAlwXCzzm7SmBfdZAsqQ_wVVUbpTvUSX1WC_x8HAjMa3gLb88-MwKL7s4OqlYntX4r&key_word=123&count=10&shop_version=1&user_id=4195355415549012&column_id=0&goods_type=0","UTF-8"));
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String[] getCombIds(String productId){
        List list=new ArrayList();
        String[] combIds=null;
        String url="https://ec.snssdk.com/product/getstock?id="+productId;

        try {
            String json=httpGet(url,"UTF-8");
            if(json!=null){
                JSONObject jsonObject=new JSONObject(json);
                JSONObject data=new JSONObject(jsonObject.getString("data"));
                JSONObject stock=new JSONObject(data.getString("stock"));
                Iterator<String> it=stock.keys();
                while(it.hasNext()){
                    String key=it.next();
                    JSONObject value = new JSONObject(stock.getString(key));
                    String combId=value.getString("id");
                    list.add(combId);
                }
                combIds=new String[list.size()];
                for(int i=0;i<list.size();i++){
                    combIds[i]=list.get(i)+"";
                }
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return combIds;

    }



    public static   String httpGet(String url, String charset)
            throws HttpException, IOException {
        String json = null;
        HttpGet httpGet = new HttpGet();

// 设置参数
        try {
            httpGet.setURI(new URI(url));
            httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36");
        } catch (URISyntaxException e) {
            throw new HttpException("请求url格式错误。" + e.getMessage());
        }
// 发送请求
        HttpClient client = new DefaultHttpClient();
        HttpResponse httpResponse = client.execute(httpGet);

// 获取返回的数据
        HttpEntity entity = httpResponse.getEntity();
        byte[] body = EntityUtils.toByteArray(entity);
        StatusLine sL = httpResponse.getStatusLine();
        int statusCode = sL.getStatusCode();
        if (statusCode == 200) {
            json = new String(body, charset);
            entity.consumeContent();
        } else {
            throw new HttpException("statusCode=" + statusCode);
        }
        return json;
    }

}
