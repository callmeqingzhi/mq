package com.mq.demo;

public class ProduceClient {

    public static void main(String[] args) throws Exception{
        MqClient.produce("Hello World");
    }
}
