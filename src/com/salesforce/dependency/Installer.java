/**
 * Copyright 2015 Salesforce.com. All rights reserved. Unauthorized reproduction
 * is a violation of applicable law. This material contains certain
 * confidential or proprietary information and trade secrets of Intuit Inc.
 */
package com.salesforce.dependency;

import static com.salesforce.dependency.enums.Command.END;
import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.salesforce.dependency.enums.Command;

/**
 * @author saung
 * @since Jun 18, 2015
 */
public class Installer {

    /**
     * 
     */
    public Installer() {
        // TODO Auto-generated constructor stub
    }


    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = null;
        do {
            input = scanner.next();
            if (input == null || input.trim().length() == 0) {
                out.println("Invalid empty input");
                continue;
            }
            // echo the input
            out.println(input);

            List<String> tokens = Arrays.asList(input.split(" "));

            if (!Command.contains(tokens.get(0))) {
                out.println("Invalid command!");
                continue;
            }



        } while (!END.toString().equals(input));

        scanner.close();
    }

}
