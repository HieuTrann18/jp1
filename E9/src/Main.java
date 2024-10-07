import Controller.CustomerController;
import Entity.Customer;
import Entity.Gender;
import Service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Hieu", Gender.MALE, 10));
        customers.add(new Customer(2, "Huong", Gender.FEMALE, 15));
        customers.add(new Customer(3, "Vinh", Gender.MALE, 20));

        CustomerService customerService = new CustomerService(customers);
        CustomerController customerController = new CustomerController(customerService);


        Customer updatedCustomer = new Customer(1, "Phi Hieu an db", Gender.FEMALE, 300000);
        customerController.Update(updatedCustomer);

        for (Customer customer : customerService.getCustomers()) {
            System.out.println(customer);
        }


    }
}
