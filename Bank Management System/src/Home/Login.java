package Home;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        System.out.println("Login Here!");
        System.out.print("Username: ");
        Scanner sc = new Scanner(System.in);
        String username = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.println("Welcome '" + username + "'");
    }
}
