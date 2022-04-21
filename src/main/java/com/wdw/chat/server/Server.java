package com.wdw.chat.server;

import com.wdw.utils.LogUtils;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(8001);
        Naming.bind("rmi://localhost:8001/server", new ServerServiceImpl());
        LogUtils.log("server", "start up successfully");
    }
}
