/**
 * Copyright 2015 Salesforce.com. All rights reserved. Unauthorized reproduction
 * is a violation of applicable law. This material contains certain
 * confidential or proprietary information and trade secrets of Intuit Inc.
 */
package com.salesforce.dependency;

import java.util.ArrayList;
import java.util.List;

/**
 * @author saung
 * @since Jun 18, 2015
 */
public class Component<T> {
    private final List<Component> dependencyList;
    private final Component parent;
    private final T data;

    /**
     * @param data
     */
    public Component(T data) {
        this(null, data);
    }

    /**
     * @param parent
     * @param data
     */
    public Component(Component parent, T data) {
        this(new ArrayList<Component>(), parent, data);
    }

    /**
     * @param dependencyList
     * @param parent
     * @param data
     */
    public Component(List<Component> dependencyList, Component parent, T data) {
        this.dependencyList = dependencyList;
        this.parent = parent;
        this.data = data;
    }

    /**
     * 
     * @param data
     */
    public void dependsOn(T data) {
        Component<T> dependency = new Component<T>(this, data);
        dependencyList.add(dependency);
    }

    /**
     * 
     * @param name
     * @return
     */
    public Component findByName(T name) {
        // check if it's parent
        if (parent != null && parent.data.equals(name)) {
            return parent;
        }

        if (name.equals(data)) {
            return this;
        }

        if (dependencyList == null || dependencyList.isEmpty()) {
            return null;
        }

        for (Component component : dependencyList) {
            if (name.equals(component.data)) {
                return component;
            }
        }

        return null;
    }

}
