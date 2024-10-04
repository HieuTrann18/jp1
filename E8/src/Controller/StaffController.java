package Controller;

import Entity.Staff;
import Service.StaffService;

import java.util.List;

public class StaffController {
    private List<Staff> staffs;
    private StaffService ss;

    public StaffController(StaffService ss) {
        this.ss = ss;
        this.staffs = ss.getStaffs();
    }

    public Staff getById(int id) {
        Staff staff = ss.getById(id);
        if(staff != null) {
            return staff;
        }
        return null;
    }
}
