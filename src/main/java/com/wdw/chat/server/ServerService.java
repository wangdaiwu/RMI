package com.wdw.chat.server;

import com.wdw.chat.client.ClientService;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerService extends Remote {
    public void login(Integer clientPort, ClientService clientService) throws RemoteException;
    public void logout(Integer clientPort) throws RemoteException;
    public void sendMessage(Integer clientPort, String message) throws RemoteException;
}
