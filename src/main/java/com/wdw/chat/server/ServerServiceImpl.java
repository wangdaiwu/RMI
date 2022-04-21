package com.wdw.chat.server;

import com.wdw.chat.client.ClientService;
import com.wdw.utils.LogUtils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerServiceImpl extends UnicastRemoteObject implements ServerService {
    public static List<ClientEntity> clientEntityList = new ArrayList<>();

    protected ServerServiceImpl() throws RemoteException {
    }

    @Override
    public void login(Integer clientPort, ClientService clientService) throws RemoteException {
        clientEntityList.add(new ClientEntity(clientPort, clientService));
        String message = String.format("client(%d) joins group chat | %d online clients",
                clientPort,
                clientEntityList.size());
        sendMessage(0, message);
        LogUtils.log("server", message);
    }

    @Override
    public void logout(Integer clientPort) throws RemoteException {
        for (ClientEntity ce : clientEntityList) {
            if (ce.getClientPort().equals(clientPort)) {
                clientEntityList.remove(ce);
                break;
            }
        }
        String message = String.format("client(%d) quit group chat | %d online clients",
                clientPort,
                clientEntityList.size());
        sendMessage(0, message);
        LogUtils.log("server", message);
    }

    @Override
    public void sendMessage(Integer clientPort, String message) throws RemoteException {
        for (ClientEntity ce : clientEntityList) {
            ce.getClientService().receiveMessage(clientPort, message);
        }
        if (!clientPort.equals(0)) {
            String var2 = String.format("client(%d)", clientPort);
            LogUtils.log("client", var2, message);
        }
    }
}
