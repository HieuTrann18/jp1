package Service;
import Entity.Customer;
import IGeneral.IGeneral;
import Global.Global;
import java.util.List;
import java.util.Optional;

public class CustomerService implements IGeneral<Customer>{
    private List<Customer> customers;
    public CustomerService(List<Customer> customers){
        this.customers = customers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @Override
    public Customer getById(int id) {
        Optional <Customer> customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        if(customer.isPresent()){
            return customer.get();
        }else{
            return null;
        }
    }

    @Override
    public Customer getByCode(String code) {
        Optional <Customer> customer = customers.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst();
        return customer.get();
    }

    @Override
    public List<Customer> getByName(String keyword) {
        return customers.stream()
                .filter(c->Global.ignoreCase(c.getName(), keyword))
                .toList();

    }
}
