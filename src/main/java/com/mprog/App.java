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
//
//    private static void authenticateClient() {
//        var scanner = new Scanner(System.in);
//        System.out.println("Choose option (1 or 2)!!!");
//        System.out.println("1. Register\n2. Login");
//        var i = scan.nextInt();
//        if (i == 1) {
//            registerClient(scanner);
//            loginClient(scanner);
//        } else if (i == 2) {
//            loginClient(scanner);
//        } else {
//            System.out.println("Please restart app, and choose right option (1 or 2)!!!");
//        }
//    }
//
//    private static void loginClient(Scanner scanner) {
//
//        System.out.println("    * * *  Welcome To Login  * * *   ");
//        System.out.println("Email > ");
//        var em = scanner.nextLine();
//        System.out.println("Password > ");
//        var pas = scanner.nextLine();
//        var userLogin = userService.login(em, pas);
//        userLogin.ifPresentOrElse(
//                App::onLoginSuccess,
//                App::onLoginFail
//        );
//    }
//
//    private static void onLoginFail() {
//        System.out.println("No such client!\nPlease retry!");
//    }
//
//    private static void onLoginSuccess(UserDto userDto) {
////        greetUser(userDto);
//        Client client = new Client(HOST, PORT, scan);
//        var thread = new Thread(client);
//        thread.start();
//    }
//
//    private static void greetUser(UserDto userDto) {
//        System.out.println("Welcome " + userDto.getEmail());
//    }
//
//    private static void registerClient(Scanner scanner) {
//        System.out.println("    * * *  Welcome To Registration  * * *   ");
//        System.out.print("Email > ");
//        var email = scanner.nextLine();
//        System.out.print("\nPassword > ");
//        var password = scanner.nextLine();
//        var userDto = UserDto.builder()
//                .email(email)
//                .password(password)
//                .build();
//
//        userService.create(userDto);
//    }
//}
