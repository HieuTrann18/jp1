package Service;

import Entity.Customer;
import IGeneric.IGeneral;

import java.util.List;

public class CustomerService implements IGeneral<Customer> {
    private List<Customer> customers;

    public CustomerService(List<Customer> customers){
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public boolean Update(Customer entity) {
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId() == entity.getId()){
                customers.set(i, entity);
                return true;
            }
        }
        return false;
    }





}
