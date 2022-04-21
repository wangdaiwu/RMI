package com.wdw.chat.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientService extends Remote {
    void receiveMessage(Integer clientPort, String message) throws RemoteException;
}
