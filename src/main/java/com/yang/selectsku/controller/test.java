package com.yang.selectsku.controller;

public class test {
    public static void main(String[] args) {



        Thread t1=new MyThread();
        t1.setName("t1");
        t1.start();
        Thread t2=new MyThread();
        t2.setName("t22");
        t2.start();


        ThreadGroup currentGroup =

                Thread.currentThread().getThreadGroup();

        int noThreads = currentGroup.activeCount();

        Thread[] lstThreads = new Thread[noThreads];

        currentGroup.enumerate(lstThreads);

        for (int i = 0; i < noThreads; i++) {

            System.out.println("线程号：" + i + " = " + lstThreads[i].getName());
            if (lstThreads[i].getName().equals("t22")){
                lstThreads[i].stop();
            }
        }

    }
}
