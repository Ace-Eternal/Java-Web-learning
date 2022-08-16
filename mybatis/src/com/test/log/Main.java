package com.test.log;


import lombok.extern.java.Log;
@Log(topic = "小王八")
public class Main {
    public static void main(String[] args) {
        System.out.println(log.getName());
        log.info("Look here");
    }
}
