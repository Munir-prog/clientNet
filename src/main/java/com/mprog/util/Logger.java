package com.mprog.util;

public final class Logger {
    private Logger(){}

    public static void log(Object o){
        System.out.println("[log] " + o);
    }
}
