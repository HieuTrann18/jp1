import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import Service.CustomerService;
import Service.InvoiceService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        customers.add(new Customer(1, "Hieu", Gender.MALE, 14));
        customers.add(new Customer(2, "Huong", Gender.FEMALE, 21));
        customers.add(new Customer(3, "Nam", Gender.MALE, 30));

        accounts.add(new Account(1, 100.000, customers.get(0)));
        accounts.add(new Account(2, 100.000, customers.get(1)));
        accounts.add(new Account(3, 100.000, customers.get(2)));

        invoices.add(new Invoice(1, 80.000, customers.get(0), LocalDate.now()));
        invoices.add(new Invoice(2, 80.000, customers.get(0), LocalDate.now()));

        invoices.add(new Invoice(1, 80.000, customers.get(1), LocalDate.now()));
        invoices.add(new Invoice(2, 10.000, customers.get(1), LocalDate.now()));

        CustomerService cs = new CustomerService(customers, invoices ,accounts);
        InvoiceService is = new InvoiceService(invoices, customers, accounts);
        CustomerController cc = new CustomerController(cs);
        InvoiceController ic = new InvoiceController(is);

//        Customer cusUpdated = new Customer(1, "Hieu dz", Gender.MALE, 15);
//        cc.update(cusUpdated);
//
//        cc.sortByName();
//
//        int inputId = 1;
//        cc.getById(inputId);
//
//        String inputName = "Hieu dz";
//        cc.getByName(inputName);

        ic.totalAmountInvoice(2);



    }
}