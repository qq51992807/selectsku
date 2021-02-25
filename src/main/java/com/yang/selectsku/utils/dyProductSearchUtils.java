package com.yang.selectsku.utils;

import org.apache.http.HttpException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.IOException;

public class dyProductSearchUtils {
    public static void main(String args[]){
//        dyProductSearchUtils.searchProduct("70204787595","耐克");
        dyProductSearchUtils.searchProduct("75317185876","");//英伟达
//        dyProductSearchUtils.searchProduct("4195355415549012","");//罗永浩
//        dyProductSearchUtils.searchProduct("66916631931","");//罗永浩
//        dyProductSearchUtils.searchProduct("110496027780","");//京东数码


    } //70204787595 胜道 //68208641192 c

    public static String searchProduct(String authorId,String keyWord){//70204787595
        String productId=null;
        try {//https://api5-normal-lite-act-lq.amemv.com/aweme/v1/promotion/user/promotion/list/?aid=2329&cursor=0&sort=0&count=1&user_id=70204787595&column_id=1&goods_type=1
            String json =getUtils.httpGet("https://api5-normal-lite-act-lq.amemv.com/aweme/v1/promotion/user/promotion/list/?aid=2329&cursor=0&sort=0&count=200&user_id="+authorId+"&column_id=0&goods_type=1","UTF-8");
            JSONObject jsonObject=new JSONObject(json);
            JSONArray jsonArray=new JSONArray(jsonObject.getString("promotions"));
            for(int i=0;i<jsonArray.length();i++){
                JSONObject product = new JSONObject(jsonArray.get(i) + "");
                String productName = product.getString("title");
//                System.out.println(productName);
                if(keyWord.equals("")){
                    System.out.println(productName+"   "+product.getString("product_id"));
                }else if(productName.contains(keyWord)){
                    productId = product.getString("product_id");
                    System.out.println(productName);
                    return productId;
                }
            }
        } catch (HttpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return productId;
    }
}
