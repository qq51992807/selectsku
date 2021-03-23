package com.yang.selectsku.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

    public static void main(String[] args){
        String reg="花?朵(?=[\\d+])";
        String test="祖国的花朵123";
        Pattern pattern=Pattern.compile(reg);
        Matcher mc=pattern.matcher(test);
        while (mc.find()){
            System.out.println(mc.group());
        }

    }

}
