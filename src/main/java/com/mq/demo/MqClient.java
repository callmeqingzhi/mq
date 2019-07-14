package com.mq.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class MqClient {

    public static void produce(String msg) throws Exception {


        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVER_PORT);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println(msg);
        out.flush();
    }


    public static String consume() throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),BrokerServer.SERVER_PORT);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        out.println("CONSUME");
        out.flush();
        String message = in.readLine();
        return message;

    }
}
