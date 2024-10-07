package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    private CustomerService cs;


    public CustomerController(CustomerService cs){
        this.cs = cs;

    }

    public void Update(Customer entity) {
        boolean isUpdated = cs.Update(entity);
        if (isUpdated) {
            System.out.println("Updated successfully:\n" + "Id: " + entity.getId() + ", Name: " + entity.getName() + ", Gender: " + entity.getGender() + ", Discount: " + entity.getDiscount() );

        } else {
            System.out.println("Fail");
        }
    }

}
