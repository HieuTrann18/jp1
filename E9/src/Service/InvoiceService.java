package Service;

import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;
import IGeneric.IGeneral;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import Global.Global;

public class InvoiceService implements IGeneral<Invoice> {
    private List<Invoice> invoices;
    private List<Customer> customers;
    private List<Account> accounts;

    public InvoiceService(List<Invoice> invoices, List<Customer> customers,List<Account> accounts){
        this.invoices = invoices;
        this.customers = customers;
        this.accounts = accounts;
    }


    public double totalAmountInvoice(int id){
        List<Invoice> ivc = invoices.stream()
                .filter(i -> i.getCustomer().getId() == id)
                .toList();
        double totalAmountDue = 0;
        for(Invoice invoices : ivc){
            double totalAmountDiscount = invoices.getAmount() * (1 - invoices.getCustomer().getDiscount() / 100.0);
            if(invoices.getCustomer().getGender() == Gender.FEMALE && invoices.getDatetime().getMonth() == Month.AUGUST){
                totalAmountDiscount *= 0.9;
            }
            totalAmountDue += totalAmountDiscount;
        }
        return totalAmountDue;

    }

    public boolean checkedBalance(int id, double totalAmountDue){
        Account cusAccount = accounts.stream()
                .filter(a -> a.getCustomer().getId() == id)
                .findFirst()
                .orElse(null);
        return cusAccount != null && cusAccount.getBalance() >= totalAmountDue;
    }

    @Override
    public void update(Invoice object) {
        invoices.stream()
                .filter(i -> i.getId() == object.getId())
                .forEach(i -> {
                    i.getCustomer().setName(object.getCustomer().getName());
                    i.getCustomer().setDiscount(object.getCustomer().getDiscount());
                    i.setAmount(object.getAmount());
                    i.setDatetime(object.getDatetime());
                });
    }

    @Override
    public List<Invoice> sort() {
        return invoices.stream()
                .sorted(Comparator.comparing(i -> i.getCustomer().getName()))
                .toList();
    }

    @Override
    public List <Invoice> getById(int id) {
        return  invoices.stream()
                .filter(c -> c.getCustomer().getId() == id)
                .toList();
    }

    @Override
    public List<Invoice> getByName(String name) {
        return invoices.stream()
                .filter(i ->Global.ignoreCase(i.getCustomer().getName(), name))
                .toList();
    }
}
