import Entity.Department;
import Entity.Employee;
import Entity.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Department> departments = new ArrayList<Department>();
        List<Employee> employees = new ArrayList<>();
        Map<String, Long> countEmployee = new HashMap<>();
        departments.add(new Department(1, "HR", "Human Resource"));
        departments.add(new Department(2, "IT", "Information Technology"));
        employees.add(new Employee(1, "Lo Van Hieu", departments.get(1), Gender.MALE, LocalDate.of(2005, 10, 18)));
        employees.add(new Employee(2, "Nguyen Van Hieu", departments.get(1), Gender.MALE, LocalDate.of(2008, 10, 1)));
        employees.add(new Employee(3, "Dat Nguyen", departments.get(1), Gender.FEMALE, LocalDate.of(2005, 10, 2)));

        /*Count total employees for each Department(Name)*/
        /*HR=2, IT=1*/
        /*way 1: using count() return Long dataType*/
//        departments
//                .stream()
//                .forEach(department -> {
//            long totalEmp = employees.stream()
//                    .filter(e -> department.getId() == e.getDepartment().getId())
//                    .collect(Collectors.toSet())
//                    .stream().count();
//            countEmployee.put(department.getCode(), totalEmp);
//        });

//        System.out.println(countEmployee);
        /* getOrDefault(base on count() must be unique, 0) = 1; iterator in MapEntry */

//        departments.forEach(d -> {
//            employees.stream()
//                    .filter(emp -> emp.getDepartment().getId() == d.getId())
//                    .peek(employee -> { //peek no need to return object
//                        countEmployee.put(d.getCode(), countEmployee.getOrDefault(d.getCode(), 0L) + 1);
//                    });
//        });
//        System.out.println(countEmployee);

        /* way 3: using Set<Object> and size() convert dataType to Long */
//        departments.stream().forEach(department -> {
//            Set<Employee> employeeSet = employees.stream()
//                    .filter(employee -> employee.getDepartment().getId() == department.getId())
//                    .collect(Collectors.toSet());
//            countEmployee.put(department.getCode(),(long) employeeSet.size());
//        });
//        System.out.println(countEmployee);


//        departments.stream().forEach(department -> {
//            Set<Employee> empFemale = employees.stream()
//                    .filter((e -> e.getGender() == Gender.FEMALE))
//                    .collect(Collectors.toSet());
//            countEmployee.put(department.getCode(), (long) empFemale.size());
//        });
//        System.out.println(countEmployee);


        departments.stream().forEach(department -> {
           Set<Employee> emp = employees.stream()
                   .filter(e -> e.getDoB().getMonth() == LocalDate.now().getMonth())
                   .collect(Collectors.toSet());
           countEmployee.put(department.getCode(), (long) emp.size());
        });
        System.out.println(countEmployee);
    }
}