package com.mprog;

import com.mprog.app.Client;

import java.util.Scanner;


import static com.mprog.settings.Settings.*;

public class App {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client(HOST, PORT, scan);
        var thread = new Thread(client);
        thread.start();
    }
}