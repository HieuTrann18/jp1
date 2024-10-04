package Service;

import Entity.Customer;
import Entity.Staff;
import IGeneral.IGeneral;
import Global.Global;
import java.util.List;
import java.util.Optional;

public class StaffService implements IGeneral<Staff> {
    private List<Staff> staffs;
    public StaffService(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    @Override
    public Staff getById(int id) {
        Optional<Staff> staff = staffs.stream()
                .filter(s -> s.getId() == id)
                .findFirst();
        if(staff.isPresent()){
            return staff.get();
        }else{
            return null;
        }
    }

    @Override
    public Staff getByCode(String code) {
        Optional <Staff> staff = staffs.stream()
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst();
        if(staff.isPresent()){
            return staff.get();
        }else{
            return null;
        }
    }

    @Override
    public List<Staff> getByName(String keyword) {
        return staffs.stream()
                .filter(s -> Global.ignoreCase(s.getName(), keyword))
                .toList();
    }
}
