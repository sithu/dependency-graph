/**
 * Copyright 2015 Intuit Inc. All rights reserved. Unauthorized reproduction
 * is a violation of applicable law. This material contains certain
 * confidential or proprietary information and trade secrets of Intuit Inc.
 */
package com.salesforce.dependency;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author saung
 * @since Jun 18, 2015
 */
public class CommandHandler {
    private final Set<Component<String>> installedComponents = new HashSet<Component<String>>();

    private final Set<Component<String>> dependencies = new HashSet<Component<String>>();

    /**
     * 
     */
    public CommandHandler() {
        // TODO Auto-generated constructor stub
    }

    /**
     * 
     * @param inputParameters
     */
    public void depend(List<String> inputParameters) {
        Component<String> component = new Component<String>(
                inputParameters.remove(0));

        for (String dependency : inputParameters) {
            component.dependsOn(dependency);
        }

        dependencies.add(component);
    }

    /**
     * 
     * @param componentName
     */
    public void install(String componentName) {
        Component<String> toBeInstalled = null;

        for (Component<String> component : dependencies) {
            toBeInstalled = component.findByName(componentName);
        }

        if (toBeInstalled == null) {
            toBeInstalled = new Component<String>(componentName);
        }

        installedComponents.add(toBeInstalled);
    }

    /**
     * 
     * @param componentName
     */
    public void remove(String componentName) {
        // TODO
    }

    /**
     * 
     * @param componentName
     */
    public void list(String componentName) {
        for (Component<String> component: installedComponents) {
            System.out.println(component.toString());
        }
    }
}
