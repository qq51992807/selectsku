package com.yang.selectsku.utils;

import org.apache.http.HttpException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

public class jdTransaction {

    public static void main(String args[]){
        System.out.println(jdTransaction.jdTransactionItem("https://item.m.jd.com/product/100006359561.html"));;
    }


    public static String jdTransactionItem(String itemLink){
        //https://item.m.jd.com/product/100010093921.html

        try {
            String message=getUtils.httpGet("http://api.web.ecapi.cn/jingdong/doItemCpsUrl?apkey=5e491c83-5e9d-ae39-02dd-0775ab448f93" +
                    "&materialId="+itemLink+"" +
                    "&key_id=J4773571450680208","UTF-8");
            JSONObject jsonObject=new JSONObject(message);
            if(jsonObject.getInt("code")==200){
                JSONObject data=new JSONObject(jsonObject.getString("data")+"");
                itemLink=data.getString("shortURL");
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }catch (JSONException e) {
            e.printStackTrace();
        }


        return itemLink;
    }

}
