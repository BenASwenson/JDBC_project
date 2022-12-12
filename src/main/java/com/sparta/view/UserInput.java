package com.sparta.view;

import java.util.Scanner;

public class UserInput {

    public static String getUserInput() {

        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        String input = "";
        while(!valid) {
            System.out.println("Please choose Json or XML format - write json for Json or xml for Xml");
            input = scanner.next();
            if (input.equalsIgnoreCase("xml")) {
                valid = true;
            } else if(input.equalsIgnoreCase("json")) {
                valid = true;
            } else {
                System.out.println("Please choose Json or XML format - write json for Json or xml for Xml");
                input = scanner.next();
            }
        }
        System.out.println("Thank you");
        return input.toLowerCase();
    }
}
