package com.mprog.app;

import lombok.SneakyThrows;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Scanner;

import static com.mprog.settings.Settings.HOST;
import static com.mprog.settings.Settings.PORT;

public class ServerThread implements Runnable {
    private final Socket socket;
    private final LinkedList<String> messagesToSend;
    private boolean hasMessages = false;
    private static final Scanner scan = new Scanner(System.in);
    private final Client client;

    public ServerThread(Socket socket, Client client){
        this.socket = socket;
        this.client = client;
        messagesToSend = new LinkedList<String>();
    }

    @Override
    public void run(){
        greetUser();
        try{
            var out = new PrintWriter(socket.getOutputStream(), true);
            var in = socket.getInputStream();
            Scanner serverIn = new Scanner(in);

            while(!socket.isClosed()){
                showMessage(in, serverIn);
                sendMessage(out);
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    @SneakyThrows
    private void showMessage(InputStream in, Scanner serverIn) throws IOException {
        if (in.available() > 0){
            if (serverIn.hasNextLine()){
                String serverMessage = serverIn.nextLine();
                if (serverMessage.equals("[Warning:] Your session will be closed!")) {
                    System.out.println(serverMessage);
                    System.out.println("Your session closed!");
                    System.out.println("We will try to reconnect after 15 seconds");
                    try {
                        client.setFlag(true);
                        System.out.println("[Warning:] write something to interrupt other Client");
                        Thread.sleep(15000L);
                        Client client = new Client(HOST, PORT, scan);
                        var thread = new Thread(client);
                        thread.start();
                        Thread.currentThread().interrupt();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                else
                    System.out.println(serverMessage);
            }
        }
    }

    private void sendMessage(PrintWriter out) {
        if(hasMessages) {
            String nextSend = "";
            synchronized (messagesToSend) {
                nextSend = messagesToSend.pop();
                hasMessages = !messagesToSend.isEmpty();
            }
            out.println(nextSend);
            out.flush();
        }
    }

    private void greetUser() {
        System.out.println("Welcome");
        System.out.println("Local Port :" + socket.getLocalPort());
        System.out.println("Server = " + socket.getRemoteSocketAddress() + ":" + socket.getPort());
    }

    public void addNextMessage(String message){
        synchronized (messagesToSend){
            hasMessages = true;
            messagesToSend.push(message);
        }
    }
}
