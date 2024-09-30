package Controller;

import Entity.Gender;
import Entity.Staff;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class StaffController {
    private static List<Staff> staffList;
    public StaffController(List<Staff> staffList) {
        StaffController.staffList = staffList;
    }

    public Optional <Staff> payHighest(){
        Optional <Staff> staffPayHighest = staffList.stream()
                .filter(s -> s.getGender() == Gender.FEMALE)
                .max(Comparator.comparing(Staff::getPay));
        return staffPayHighest;
    }

    public static List<Staff> searchById(String id){
        return staffList.stream().
                filter(s -> s.getId().equals(id))
                .collect(toList());
    }

    public static List<Staff> searchByName(String keyword){
        return staffList.stream().
                filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(toList());
    }

    public void updateStaffName(String staffId, String newName){
        staffs.stream()
            .filter(s -> s.getId().equals(staffId))
            .forEach(s -> s.setName(newName));
    }

}
