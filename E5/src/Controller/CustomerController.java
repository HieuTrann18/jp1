package Controller;
import Entity.Account;
import Entity.Customer;
import Entity.Invoice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
public class CustomerController {
    private List<Customer> customers;
    private List<Account> accounts; // Thêm danh sách tài khoản
    private List<Invoice> invoices;
    public CustomerController(List<Customer> customers, List<Account> accounts, List<Invoice> invoices) {
        this.customers = customers;
        this.accounts = accounts;
        this.invoices = invoices;
    }

    public List <Customer> sortedByCustomerName(){
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .collect(Collectors.toList());
    }

    public List <Customer> sortedByCustomerId(){
        return customers.stream()
                .sorted(Comparator.comparing(Customer::getId))
                .collect(Collectors.toList());
    }

    public Optional<Customer> searchByName(String keyword){
        return customers.stream()
                .filter(s -> s.getName().toLowerCase().contains(keyword.toLowerCase()))
                .findFirst();
    }

    public Optional<Customer> searchById(int keyword){
        return customers.stream()
                .filter(s -> s.getId() == keyword)
                .findFirst();
    }

    public void listCustomerAccountInvoice(){
        for(Customer customer : customers){
            System.out.println("Customer: " + customer.getName());

            Account account = accounts.stream()
                    .filter(acc -> acc.getCustomer().getId() == customer.getId())
                    .findFirst()
                    .orElse(null);
            if(account != null){
                System.out.println("Account Balance: " + account.getBalance());

            }else{
                System.out.println("No Account Balance");
                continue;
            }
            List<Invoice> customerInvoices = invoices.stream()
                    .filter(inv -> inv.getCustomer().getId() == customer.getId())
                    .toList();
            for(Invoice invoice : customerInvoices){
                double totalAmount = invoice.getAmount() * (1 - (customer.getDiscount() / 100.0));
                System.out.println("Invoice ID: " + invoice.getId() + ", Amount: " + invoice.getAmount() + ", Date: " + invoice.getDateTime());
                System.out.println("Discount: " + customer.getDiscount() + "%, Total Amount after Discount: " + totalAmount);
                if (account.getBalance() >= totalAmount) {
                    System.out.println("Sufficient balance to pay this invoice.");
                    System.out.println("<=============================================>");
                } else {
                    System.out.println("Insufficient balance to pay this invoice.");
                    System.out.println("<=============================================>");
                }
            }
        }
    }
}
