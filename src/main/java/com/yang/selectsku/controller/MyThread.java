package com.yang.selectsku.controller;


public class MyThread extends Thread{

    @Override

    public void run() {

        try {

           while (1==1) {
               System.out.println("start");
               sleep(1000 * 10);
           }
            /**
             逻辑代码
             */

        } catch (InterruptedException e) {

//            Logger.info("线程：" + Thread.currentThread().getName()+"结束.");

            System.out.println(e.getMessage());

        }

    }

}
