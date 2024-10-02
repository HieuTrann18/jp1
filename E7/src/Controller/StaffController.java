package Controller;
import Entity.Staff;
import Service.GetPaidService;

import java.util.List;
import java.util.Optional;

public class StaffController extends GetPaidService {

    private static List<Staff> staffs;

    public StaffController(List<Staff> staffs) {
        StaffController.staffs = staffs;
    }

    @Override
    public double getPaid(){
        return 0;
    }

    public double getPaid(String keyword){
        Optional <Staff> staffOpt = staffs.stream()
                .filter(s -> s.getName().equalsIgnoreCase(keyword))
                .findFirst();
        if(staffOpt.isPresent()){
            Staff staffs = staffOpt.get();
            return staffs.getPaid();
        }else{
            System.out.println("Staff not found " + keyword);
            return 0.0;
        }
    }

    public void displayInfo(String keyword){
        Optional <Staff> staffIf = staffs.stream()
                .filter(d -> d.getName().equalsIgnoreCase(keyword))
                .findFirst();
        if(staffIf.isPresent()){
            Staff staffs = staffIf.get();
            System.out.println(staffs.toString());
        }else{
            System.out.println("Staff not found " + keyword);
        }
    }
}
