package com.wdw.hello.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloService extends Remote {
    public void sayHello() throws RemoteException;
}
