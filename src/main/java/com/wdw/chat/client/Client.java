package com.wdw.chat.client;

import com.wdw.chat.server.ServerService;
import com.wdw.utils.LogUtils;
import com.wdw.utils.PortUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.server.UnicastRemoteObject;

public class Client {
    public static void main(String[] args) throws Exception {
        ClientService clientService = new ClientServiceImpl();
        Integer port = PortUtils.allocatePort();
        UnicastRemoteObject.exportObject(clientService, port);
        LogUtils.log("client-info", "start up successfully");
        LogUtils.log("client-info", "port", port.toString());

        ServerService serverService = (ServerService) Naming.lookup("rmi://localhost:8001/server");
        serverService.login(port, clientService);

        BufferedReader clientInput = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        while (flag) {
            String message = clientInput.readLine();
            if ("/logout".equals(message)) {
                clientInput.close();
                serverService.logout(port);
                UnicastRemoteObject.unexportObject(clientService, true);
                flag = false;
            } else {
                serverService.sendMessage(port, message);
            }
        }
        LogUtils.log("client-info", "logout");
    }
}
