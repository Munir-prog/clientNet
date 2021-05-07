package com.mprog;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        var scanner = new Scanner(System.in);
        while (true){
            Thread.sleep(5000L);
            System.out.println("hello");
            var s = scanner.nextLine();
            System.out.println(s);
            System.out.println("we ");
        }

    }
}
