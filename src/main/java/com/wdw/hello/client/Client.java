package com.wdw.hello.client;

import com.wdw.hello.server.HelloService;

import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        HelloService helloService = (HelloService) Naming.lookup("rmi://localhost:8080/server");
        helloService.sayHello();
    }
}
