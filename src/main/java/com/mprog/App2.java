//package com.mprog;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//import java.nio.charset.StandardCharsets;
//
//import static com.mprog.util.Logger.log;
//
//
//public class App2 {
//    public static void main(String[] args) {
//
//        log("Client starting...");
//        try (var socket = new Socket("localhost", 9754);
//             var br = new BufferedReader(new InputStreamReader(System.in));
//             var out = new PrintWriter(socket.getOutputStream(), true,
//                     StandardCharsets.UTF_8);
//             var in = new BufferedReader(new InputStreamReader(socket.getInputStream(),
//                     StandardCharsets.UTF_8));
//        ){
//            log("Client connected to socket");
//            while (!socket.isClosed()){
//                if (in.ready()){
//                    System.out.print(">");
//
//                    var clientCommand = in.readLine();
//                    out.println(clientCommand);
//
//                    log("Client sent message " + clientCommand + " to server.");
////                    Thread.sleep(1000);
//                    if (clientCommand.equalsIgnoreCase("disconnect")){
//                        log("Client kill connections");
////                        Thread.sleep(2000);
//                        String response;/*(response = in.readLine()) != null*/
//                        if (in.ready()){
//                            log("reading...");
//                            log(in.readLine());
//                        }
//                        break;
//                    }
//
//                    log("Client sent message & start waiting for data from server...");
////                    Thread.sleep(2000);
//                    if (in.ready()){
//                        log("reading...");
//                        log(in.readLine());
//                    }
//                }
//            }
//            log("Closing connections & channels on clientSide - DONE.");
//        } catch (IOException /*| InterruptedException*/ e) {
//            e.printStackTrace();
//        }
//        log("Client finished");
//    }
//}
