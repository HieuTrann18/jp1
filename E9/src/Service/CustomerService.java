package Service;

import Entity.Account;
import Entity.Customer;
import Entity.Invoice;
import IGeneric.IGeneral;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import Global.Global;

public class CustomerService implements IGeneral<Customer> {
    private List<Customer> customers;
    private List<Invoice> invoices;
    private List<Account> accounts;

    public CustomerService(List<Customer> customers, List<Invoice> invoices, List<Account> accounts){
        this.customers = customers;
        this.invoices = invoices;
        this.accounts = accounts;
    }

    @Override
    public void update(Customer object) {
        customers.stream()
                .filter(c -> c.getId() == object.getId())
                .forEach(c ->{
                    c.setName(object.getName());
                    c.setGender(object.getGender());
                    c.setDiscount(object.getDiscount());
                });
    }

    @Override
    public List<Customer> sort() {
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    @Override
    public List <Customer> getById(int id) {
        return customers.stream()
                .filter(c -> c.getId() == id)
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> getByName(String name) {
        return customers.stream()
                .filter(c -> Global.ignoreCase(c.getName(), name))
                .collect(Collectors.toList());
    }







}
