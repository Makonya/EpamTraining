package com.epam.marketing;

import java.util.*;

public class EmployeeCreator {
    private static String[] arrayNames = {"Evgeniy", "Vasya", "Petya", "Fedya",
            "Yasha", "Masha", "Alina", "Slava", "Sasha", "Tina",
            "Alisa", "Katya", "Adina", "Iliya", "Rinat", "Inga"};

    private static List<Employee> randomEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            employees.add(randomEmployee());
        }
        return employees;
    }

    private static Employee randomEmployee() {
        Random random = new Random();
        return new Employee(arrayNames[random.nextInt(16)]);
    }

    public static void main(String[] args) {
        System.out.printf("%10d\n", 1);
        System.out.printf("%4d %11d\n", 2,3);
        System.out.printf("%2d %4d %5d %5d\n", 4,5,6,7);
        System.out.printf("%1d %1d %1d %1d %1d %1d %1d %1d\n", 8, 9, 10, 11, 12, 13, 14, 15);
        System.out.println();

        Employee.addEmployees(randomEmployee(), randomEmployees(2));
        Employee.addEmployees(Employee.getEmployee(2), randomEmployees(2));
        Employee.addEmployees(Employee.getEmployee(3), randomEmployees(2));
        Employee.addEmployees(Employee.getEmployee(4), randomEmployees(2));
        Employee.addEmployees(Employee.getEmployee(5), randomEmployees(2));
        Employee.addEmployees(Employee.getEmployee(6), randomEmployees(2));
        Employee.addEmployees(Employee.getEmployee(7), randomEmployees(2));

        Employee.getEmployee(2).printLegacies();
        Employee.getEmployee(7).printChildren();
        Employee.getEmployee(8).printParents();

    }
}
