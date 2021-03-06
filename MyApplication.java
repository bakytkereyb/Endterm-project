import controllers.UserController;
import entities.Transaction;
import entities.User;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MyApplication {
    // constant variables to control all functions
    private final UserController controller;

    // constant variable for input system
    private final Scanner scanner;

    private User loginnedUser = null;

    // Constructor for creating a new MyApplication
    public MyApplication(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }



    // method to start application
    public void start() {
        System.out.println("Hello, dear user! This is online bank management system!");
        while (true) {
            System.out.println("Write username and password in format 'username password' to log in");
            try {
                String username = scanner.next();
                String password = scanner.next();
                User user = controller.getUser(username);
                if (user == null) {
                    System.out.println("Incorrect username or password!");
                    continue;
                }
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    loginnedUser = user;
                    // true - admin, false - customer
                    if (loginnedUser.isUser_type()) {
                        adminOptions();
                    }
                    else {
                        customerOptions();
                    }
                }
                else {
                    System.out.println("Incorrect username or password!");
                    continue;
                }

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void adminOptions() {
        while (true) {
            System.out.println("Below you can see functions to use application:");
            System.out.printf("%5s %1s","1:", "Show account information");
            System.out.println();
            System.out.printf("%5s %1s","2:", "Create new customer account");
            System.out.println();
            System.out.printf("%5s %1s","3:", "Search user by username");
            System.out.println();
            System.out.printf("%5s %1s","4:", "Create new admin account");
            System.out.println();
            System.out.printf("%5s %1s","0:", "Log out");
            System.out.println();
            try {
                System.out.print("In order to control, write the number of function:");
                int numberF = scanner.nextInt();
                if (numberF == 1) {
                    showAccountInfo();
                } else if (numberF == 2) {
                    createAccount(false);
                } else if (numberF == 3) {
                    searchUserByUsername();
                } else if (numberF == 4) {
                    createAccount(true);
                } else{
                    return;
                }
            } catch (InputMismatchException i) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("********************************");
        }
    }
    private void showAccountInfo() {
        System.out.println(loginnedUser.getUserInfo());
    }
    private void createAccount(boolean user_type) {
        System.out.println("Write username and password in format: 'username password'");
        String username = scanner.next();
        String password = scanner.next();

        System.out.println("Write full name");
        String full_name = scanner.next();

        System.out.println("Write address");
        String address = scanner.next();
        User user = new User(username, password, user_type, full_name, address);
        System.out.println(controller.createUser(user));
    }

    private void searchUserByUsername() {
        System.out.println("Write username");
        String username = scanner.next();
        User user = controller.getUser(username);

        System.out.println(user.getUserInfo());
    }

    private void customerOptions() {
        while (true) {
            System.out.println("Below you can see functions to use application:");
            System.out.printf("%5s %1s","1:", "Show account information");
            System.out.println();
            System.out.printf("%5s %1s","2:", "Show card information");
            System.out.println();
            System.out.printf("%5s %1s","3:", "Transfer money to another username");
            System.out.println();
            System.out.printf("%5s %1s","4:", "Show transaction history");
            System.out.println();
            System.out.printf("%5s %1s","0:", "Log out");
            System.out.println();
            try {
                System.out.print("In order to control, write the number of function:");
                int numberF = scanner.nextInt();
                if (numberF == 1) {
                    showAccountInfo();
                } else if (numberF == 2) {
                    showCardInfo();
                } else if (numberF == 3) {
                    transferMoney();
                } else if (numberF == 4) {
                    showTransactionHistory();
                } else{
                    return;
                }
            } catch (InputMismatchException i) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("********************************");
        }
    }
    private void showCardInfo() {
        System.out.println(controller.getCardInfo(loginnedUser.getUsername()));
    }
    private void transferMoney() {
        System.out.println("Write username whom you want to transfer money");
        String to_username = scanner.next();
        System.out.println("How much money you want to transfer");
        int money = scanner.nextInt();

        System.out.println(controller.transferMoney(loginnedUser.getUsername(), to_username, money));
    }

    private void showTransactionHistory() {
        List<Transaction> transactions = controller.getTransactionHistory(loginnedUser.getUsername());
        for(Transaction transaction : transactions) {
            System.out.println(transaction.getTransactionInfo());
        }
    }
}
