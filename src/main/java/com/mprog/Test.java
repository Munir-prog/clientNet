package com.mprog;

import lombok.Getter;

@Getter
public class Test {
    private String test = "testGmnj,etter";

    public static void main(String[] args) {
        var test = new Test();
        System.out.println(test.getTest());
    }
}
