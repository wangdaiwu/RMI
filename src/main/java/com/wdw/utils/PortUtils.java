package com.wdw.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class PortUtils {
    private static final int INIT_PORT = 8080;

    public static int allocatePort() {
        int port = INIT_PORT;
        while (isPortUsing(port)) {
            port += 1;
        }
        return port;
    }

    private static boolean isPortUsing(int port) {
        try {
            InetAddress theAddress = InetAddress.getByName("localhost");
            new Socket(theAddress, port);
            return true;
        } catch (IOException ignored) {
        }
        return false;
    }
}
