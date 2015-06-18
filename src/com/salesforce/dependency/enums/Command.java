/**
 * Copyright 2015 Intuit Inc. All rights reserved. Unauthorized reproduction
 * is a violation of applicable law. This material contains certain
 * confidential or proprietary information and trade secrets of Intuit Inc.
 */
package com.salesforce.dependency.enums;

/**
 * @author saung
 * @since Jun 18, 2015
 */
public enum Command {
    DEPEND(2, Integer.MAX_VALUE), 
    INSTALL(1, 1), 
    REMOVE(1, 1), 
    LIST(0, 0), 
    END(0, 0);

    private final int minNumArguments;

    private final int maxNumArguments;

    /**
     * Default constructor
     * 
     * @param maxNumAgruments
     */
    Command(int minNumAgruments, int maxNumAgruments) {
        this.minNumArguments = minNumAgruments;
        this.maxNumArguments = maxNumAgruments;
    }

    /**
     * Checks whether command name exists or not.
     * 
     * @param commandName
     * @return
     */
    public static boolean contains(String commandName) {
        for (Command command : Command.values()) {
            if (command.name().equals(commandName)) {
                return true;
            }
        }

        return false;
    }

}
