import Controller.StaffController;
import Entity.Manager;
import Entity.Staff;
import Entity.Technician;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Staff> staffs = new ArrayList<>();
        staffs.add(new Manager("Hieu", 1000,100));
        staffs.add(new Technician("Vinh", 1200,100));
        staffs.add(new Manager("Phong", 1100,100));

        StaffController staffController = new StaffController(staffs);
        String input = "Vinh";

        staffController.displayInfo(input);
        double getPaid = staffController.getPaid(input);
        System.out.println(input + " " + getPaid);
    }
}