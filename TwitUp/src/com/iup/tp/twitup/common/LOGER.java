package com.iup.tp.twitup.common;

public class LOGER {

    public static void success(String log){
        System.out.println("✅ " + log);
    }

    public static void err(String err){
        System.err.println("❌ " + err);
    }

    public static void debug(String log){
        System.out.println(log);
    }


}
