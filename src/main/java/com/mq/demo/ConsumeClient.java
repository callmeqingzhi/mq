package com.mq.demo;

public class ConsumeClient {

    public static void main(String[] args) throws Exception{
        String s = MqClient.consume();
        System.out.println("获取的消息是："+s);
    }
}
