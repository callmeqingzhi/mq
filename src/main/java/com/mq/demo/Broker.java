package com.mq.demo;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {

    //队列存储消息的最大数量
    private final static int MAX_SIZE = 3;

    //保存消息数据的容器
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_SIZE);

    //生产消息
    public static void produce(String message) {
        if (messageQueue.offer(message)) {

            System.out.println("成功向消息处理中心投递消息：" + message + "，当前暂存的消息数为：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内暂存的消息达到最大负荷！");
        }
        System.out.println("=========================");
    }


    //消费消息
    public static String consume() {
        String msg = messageQueue.poll();
        if (msg != null) {
            System.out.println("已经消费消息：" + msg + "，当前暂存消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心没有消息可供消费！");
        }
        System.out.println("=========================");

        return msg;
    }




}
