package Controller;

import Entity.Customer;
import Service.CustomerService;

import java.util.List;

public class CustomerController {
    private CustomerService cs;
    private List<Customer> customers;
    public CustomerController(CustomerService cs) {
        this.cs = cs;
    }

    public void update(Customer object){
        cs.update(object);
        System.out.println("Customer updated successfully");
        System.out.println(object);
    }

    public List<Customer> sortByName(){
        List<Customer> customers = cs.sort();
        System.out.println("customer list after sorting by name: ");
        customers.forEach(System.out::println);
        return customers;
    }



    public List<Customer> getByName(String name){
        List<Customer> cus1 = cs.getByName(name);
        if(cus1 != null){
            System.out.println("Found customer by name: " + cus1);
        }else{
            System.out.println("Not found");
        }
        return cus1;
    }




}
