package com.mjc.school;

import java.util.*;

public class Main {
    private static Map <String, String> menu = new LinkedHashMap<>();

    static {
        menu.put("1", "Get all news.");
        menu.put("2", "Get news by id.");
        menu.put("3", "Create news.");
        menu.put("4", "Update news.");
        menu.put("5", "Remove news by id.");
        menu.put("0", "Exit.");
    }
    public static void main(String[] args) {
        Operations operations = new Operations();
        while (true){
            try{
                String command = printMenu();
                if (command == null) {
                    continue;
                }
                switch (command) {
                    case "0" -> System.exit(0);
                    case "1" -> operations.getAllNews();
                    case "2" -> operations.getNewsById();
                    case "3" -> operations.addNews();
                    case "4" -> operations.updateNews();
                    case "5" -> operations.deleteNewsById();
                }

            } catch (RuntimeException e){
                System.out.println(e.getMessage());
            }

        }

    }

    private static String printMenu(){
        System.out.println("Enter the number of operation:");
        Scanner sc = new Scanner(System.in);
        menu.forEach((K,V) -> System.out.println(K+" - "+V));

        String command = sc.nextLine();
        if (menu.containsKey(command)){
            System.out.println("Operation: "+menu.get(command));
            return command;
        } else {
            System.out.println("Command not found");
        }
        return null;
    }
}