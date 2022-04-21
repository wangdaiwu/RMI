package com.wdw.hello.server;

import com.wdw.utils.DateUtils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements HelloService {
    protected HelloServiceImpl() throws RemoteException {
    }

    @Override
    public void sayHello() throws RemoteException {
        System.out.printf("[%s] hello world!%n", DateUtils.logDate());
    }
}
