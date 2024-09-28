import Controller.StaffController;
import Controller.StudentController;
import Entity.Gender;
import Entity.Staff;
import Entity.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            List<Student> students = new ArrayList<>();
            students.add(new Student("C2309G5974", "Hai", LocalDate.of(2005, 01, 18), Gender.MALE, "Ha Noi"));
            students.add(new Student("C2309G5974", "Vinh", LocalDate.of(2008, 01, 18), Gender.MALE, "Ha Noi"));
            students.add(new Student("C2309G5974", "Hieu", LocalDate.of(1999, 01, 18), Gender.MALE, "Ha Noi"));
            students.forEach(System.out::println);


            List<Staff> staffs = new ArrayList<>();
            staffs.add(new Staff("C2309G1","Hieu", "Bac Ninh", Gender.MALE, "AptechEducation", 100000));
            staffs.add(new Staff("C2309G2","Vinh", "Bac Ninh", Gender.MALE, "AptechEducation", 500000));
            staffs.add(new Staff("C2309G3","Mai", "Bac Ninh", Gender.FEMALE, "AptechEducation", 400000));
            staffs.forEach(System.out::println);





            System.out.println("Nguoi co so tuoi tre nhat la: ");
            StudentController sc = new StudentController(students);
            Optional<Student> studentYoungest = sc.getYoungest();
            System.out.println(studentYoungest);

            StudentController.getByName("hieu").forEach(System.out::println);


            System.out.println("Nhan vien nu co muc luong cao nhat la: ");
            StaffController stc = new StaffController(staffs);
            Optional<Staff> staffPayHighest = stc.payHighest();
            System.out.println(staffPayHighest);


            System.out.println("Ket qua tim kiem theo id: ");
            StaffController.searchById("C2309G1").forEach(System.out::println);

            System.out.println("Ket qua tim kiem theo ten: ");
            StaffController.searchByName("Vinh").forEach(System.out::println);

        }
    }
