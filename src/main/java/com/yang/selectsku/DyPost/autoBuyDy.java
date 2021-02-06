package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.dyGetCombIdsUtils;
import com.yang.selectsku.utils.dyProductSearchUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class autoBuyDy implements Runnable{



    String itemName;
    String authorId;

    String keyWord;

    public autoBuyDy(String itemName,String authorId,String keyWord){
        this.itemName=itemName;
        this.authorId=authorId;
        this.keyWord=keyWord;
    }

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
    public static void main(String args[]){
        autoBuyDy autoBuyDy=new autoBuyDy("鞋子","70204787595","DD1503");
        new Thread(autoBuyDy,"auto").start();
//        autoBuyDy autoBuyDy2=new autoBuyDy("鞋子","70204787595","DD1503");//1391
////        new Thread(autoBuyDy2,"auto2").start();
////        autoBuyDy autoBuyDy3=new autoBuyDy("鞋子","70204787595","DD1503");//1391
////        new Thread(autoBuyDy3,"auto3").start();
    }

    @Override
    public void run() {
        boolean flag=true;
        while (flag){
            String productId= dyProductSearchUtils.searchProduct(authorId,keyWord);
            if(productId!=null){
                String[] combIds= dyGetCombIdsUtils.getCombIds(productId);
                if(flag) {
                    for (int i = 0; i < 30; i++) {
                        int num = i + 1;
                        new Thread(new commitDy(itemName, authorId, productId,combIds), "抢购线程" + num).start();
                    }
                }
                flag=false;
            }else {
                System.out.println(df.format(new Date())+"--暂未发现搜索商品-"+keyWord);
            }
        }
    }
}
