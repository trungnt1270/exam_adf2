package com.company;

import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String choose = null;
        boolean exit = false;
        StudentManager studentManager = new StudentManager();
        int studentId;

        // show menu
        showMenu();
        while (true) {
            choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    studentManager.add();
                    break;
                case "2":
                    studentId = studentManager.inputId();
                    studentManager.delete(studentId);
                    break;
                case "3":
                    studentManager.show();
                    break;
                case "4":
                    System.out.println("exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("invalid! please choose action in below menu:");
                    break;
            }
            if (exit) {
                break;
            }
            // show menu
            showMenu();
        }
    }

    /**
     * create menu
     */
    public static void showMenu() {
        System.out.println("\n-----------menu------------");
        System.out.println("1. Add student.");
        System.out.println("2. Delete student by id.");
        System.out.println("3. Show student.");
        System.out.println("4. exit.");
        System.out.println("---------------------------");
        System.out.print("Please choose: ");
    }
}