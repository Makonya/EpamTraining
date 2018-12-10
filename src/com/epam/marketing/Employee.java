package com.epam.marketing;

import java.util.*;

public class Employee {
    private static int counter = 1;
    private static Map<Integer, Employee> employees = new HashMap<>();

    private int id;
    private int parentId;
    private String name;
    private Set<Employee> children = new HashSet<>();

    public Employee(String name) {
        this.id = createID();
        this.name = name;
        employees.put(this.id, this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getChildren() {
        return children;
    }

    private int createID() {
        return counter++;
    }

    public static Employee getEmployee(int id) {
        return employees.get(id);
    }

    public static void addEmployees(Employee employee, List<Employee> children) {
        employee.children.addAll(children);
        for (Employee child : children) {
            child.parentId = employee.id;
        }
    }

    public void printChildren() {
        System.out.printf("%d-%s's children: ", this.id, this.name);
        StringBuilder result = new StringBuilder();
        for (Employee employee : this.getChildren()) {
            if (employee.parentId == this.id) {
                result.append(employee.id).append("-").append(employee.name).append(", ");
            }
        }
        result.delete(result.length() - 2, result.length());
        result.append(".\n");
        System.out.print(result);
    }

    public void printParents() {
        System.out.printf("%d-%s's parents: ", this.id, this.name);
        int parentID = this.parentId;
        StringBuilder result = new StringBuilder();
        while (parentID != 0) {
            result.append(employees.get(parentID).id).append("-").append(employees.get(parentID).name).append(", ");
            parentID = employees.get(parentID).parentId;
        }
        result.delete(result.length() - 2, result.length());
        result.append(".\n");
        System.out.print(result);
    }

    public void printLegacies() {
        System.out.printf("%d-%s's children:\n", this.id, this.name);
        for (Employee child : children) {
            System.out.printf("%d-%s ", child.id, child.name);
            if (child.getChildren().size() > 0) {
                child.printLegacies();
            }
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
