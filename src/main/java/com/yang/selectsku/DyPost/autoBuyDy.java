package com.yang.selectsku.DyPost;

import com.yang.selectsku.utils.dyGetCombIdsUtils;
import com.yang.selectsku.utils.dyProductSearchUtils;

public class autoBuyDy implements Runnable{



    String itemName="鞋子";
    String authorId="70204787595";

    String keyWord="dunk";


    public static void main(String args[]){
        autoBuyDy autoBuyDy=new autoBuyDy();
        new Thread(autoBuyDy,"auto").start();
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
                System.out.println("暂未发现搜索商品");
            }
        }
    }
}
