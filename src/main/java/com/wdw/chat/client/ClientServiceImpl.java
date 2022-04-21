package com.wdw.chat.client;

import com.wdw.utils.LogUtils;

import java.rmi.RemoteException;

public class ClientServiceImpl implements ClientService {
    @Override
    public void receiveMessage(Integer clientPort, String message) throws RemoteException {
        if (clientPort.equals(0)) {
            LogUtils.log("server-info", message);
        }
        else {
            String var2 = String.format("client(%d)", clientPort);
            LogUtils.log("message", var2, message);
        }
    }
}
