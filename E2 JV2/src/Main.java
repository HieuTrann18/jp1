import Entity.Department;
import Entity.Employee;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(1, "HR"));
        departments.add(new Department(2, "IT"));

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Tran The Hieu", departments.get(1), LocalDate.of(2005, 9, 18), "Male", "Bac Ninh", "Tu Son", "0971703373"));
        employees.add(new Employee(2, "Ngo Nhat Mai", departments.get(0), LocalDate.of(2005, 10, 25), "Female", "Bac Ninh", "Tu Son", "0973630943"));

        Map<String, Long> employeeCountMap = new HashMap<>();
        Map<String, Long> maleCountMap = new HashMap<>();
        Map<String, Long> birthdayCountMap = new HashMap<>();

        departments.forEach(department -> {
            long countEmp = employees.stream()
                    .filter(employee -> employee.getDepartment().getId() == department.getId())
                    .count();
            employeeCountMap.put(department.getName(), countEmp);
        });
        System.out.println("Employee Count: " + employeeCountMap);

        departments.forEach(department -> {
            long countMale = employees.stream()
                    .filter(e -> e.getDepartment().getId() == department.getId() && e.getGender().equals("Male"))
                    .count();
            maleCountMap.put(department.getName(), countMale);
        });
        System.out.println("Male Count: " + maleCountMap);

        departments.forEach(department -> {
            long countBirthDay = employees.stream()
                    .filter(e -> e.getDepartment().getId() == department.getId() && e.getDateOfBirth().getMonthValue() == 10)
                    .count();
            birthdayCountMap.put(department.getName(), countBirthDay);
        });
        System.out.println("Birthday Count (October): " + birthdayCountMap);
    }
}
