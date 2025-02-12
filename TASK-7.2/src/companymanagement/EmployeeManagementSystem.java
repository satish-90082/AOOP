package companymanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating Employee List
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "Engineering", 70000));
        employees.add(new Employee(103, "Charlie", "Finance", 60000));
        employees.add(new Employee(104, "David", "HR", 55000));
        employees.add(new Employee(105, "Eve", "Engineering", 75000));

        // Sorting by Salary (Ascending)
        System.out.println("Sorting by Salary (Ascending):");
        Collections.sort(employees, new SortBySalaryAsc());
        employees.forEach(System.out::println);

        // Sorting by Salary (Descending)
        System.out.println("\nSorting by Salary (Descending):");
        Collections.sort(employees, new SortBySalaryDesc());
        employees.forEach(System.out::println);

        // Sorting by Name
        System.out.println("\nSorting by Name:");
        Collections.sort(employees, new SortByName());
        employees.forEach(System.out::println);

        // Sorting by Department
        System.out.println("\nSorting by Department:");
        Collections.sort(employees, new SortByDepartment());
        employees.forEach(System.out::println);
    }
}
