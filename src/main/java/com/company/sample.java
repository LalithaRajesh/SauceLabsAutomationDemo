package com.company;

import org.testng.annotations.Test;

public class sample {

    @Test
    void setUp(){
        System.out.println("Opening Browser");
    }

    @Test
    void login(){
        System.out.println("Login Browser");
    }

    @Test
    void tearDown(){
        System.out.println("Close Browser");
    }
}
