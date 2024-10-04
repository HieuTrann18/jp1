package Controller;

import Entity.Customer;
import Entity.Staff;
import Service.CustomerService;
import Service.StaffService;

import java.util.List;

public class CustomerController {
    private List<Customer> customers;
    private CustomerService cs;

    public CustomerController(CustomerService cs) {
        this.cs = cs;
        this.customers = cs.getCustomers();
    }

    public Customer getById(int id) {
        Customer customer = cs.getById(id);
        if(customer != null) {
            return customer;
        }
        return null;
    }

}
