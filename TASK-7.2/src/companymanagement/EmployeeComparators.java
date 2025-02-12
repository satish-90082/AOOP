package companymanagement;

import java.util.Comparator;

// Comparator to sort employees by salary (Ascending)
class SortBySalaryAsc implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e1.getSalary(), e2.getSalary());
    }
}

// Comparator to sort employees by salary (Descending)
class SortBySalaryDesc implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return Double.compare(e2.getSalary(), e1.getSalary());
    }
}

// Comparator to sort employees by name (Alphabetical Order)
class SortByName implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

// Comparator to sort employees by department (Alphabetical Order)
class SortByDepartment implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
        return e1.getDepartment().compareTo(e2.getDepartment());
    }
}
