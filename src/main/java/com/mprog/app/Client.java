package com.mprog.app;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;



public class Client implements Runnable{

    private final String serverHost;
    private final int serverPort;
    private final Scanner scanner;
    @Setter
    private  boolean flag = false;

    public Client(String serverHost, int serverPort, Scanner scanner){
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.scanner = scanner;
    }


    @Override
    public void run() {
        try{
            Socket socket = new Socket(serverHost, serverPort);
            Thread.sleep(1000);

            ServerThread serverThread = new ServerThread(socket, this);
            Thread serverAccessThread = new Thread(serverThread);
            serverAccessThread.start();

            while(serverAccessThread.isAlive()){
                if(scanner.hasNextLine()){
                    var message = scanner.nextLine();
                    serverThread.addNextMessage(message);
                }
                if (flag){
                    Thread.currentThread().interrupt();
                    Thread.sleep(1000L);
                }

            }
        }catch(IOException | InterruptedException e){
            System.err.println("Fatal Connection error!");
            e.printStackTrace();
        }
    }
//
//    public void setFlag(boolean flagFrom) {
//       this.flag = flagFrom;
//    }
}
//            CheckActivity checkActivity = new CheckActivity(socket);
//            Thread checkActivityThread = new Thread(checkActivity);
//            checkActivityThread.start();