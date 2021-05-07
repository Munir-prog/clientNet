package com.mprog.app;

import java.net.Socket;
import java.net.SocketException;

public class CheckActivity implements Runnable {
    private final Socket socket;
    public static String message;

    public CheckActivity(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

    }

    public static void setServerMessage(String serverMessage) {
        message = serverMessage;
    }
}

