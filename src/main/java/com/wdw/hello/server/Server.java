package com.wdw.hello.server;

import com.wdw.utils.DateUtils;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(8080);
        Naming.bind("rmi://localhost:8080/server", new HelloServiceImpl());
        System.out.printf("[%s] rmi server start success%n", DateUtils.logDate());
    }
}
