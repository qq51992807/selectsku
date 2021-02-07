package com.yang.selectsku.utils;

import org.apache.http.HttpException;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

public class dyGetCombIdUtils {
    public static void main(String[] args){
        dyGetCombIdUtils.getCombId("3462088725570425194");
    }
    public static  String[] getCombId(String productId){
        String[] combIds;
        try {
            String json=getUtils.httpGet("https://ec.snssdk.com/product/getstock?id="+productId,"UTF-8");//3462088725570425194
            System.out.println(json);
//            JSONObject jsonObject=new JSONObject(json);
//            System.out.println(jsonObject.getString("data"));;
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (JSONException e) {
//            e.printStackTrace();
//        }
        return  null;
    }
}
