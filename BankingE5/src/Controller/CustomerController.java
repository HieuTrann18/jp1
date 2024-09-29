package Controller;

import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerController {
    private List<Customer> customers;
    private List<Account> accounts;
    private List<Invoice> invoices;

    public CustomerController(List<Customer> customers, List<Account> accounts, List<Invoice> invoices) {
        this.customers = customers;
        this.accounts = accounts;
        this.invoices = invoices;
    }

    public List<Customer> sortedName() {
        List<Customer> sortByName = customers.stream()
                .sorted(Comparator.comparing(Customer::getName))
                .toList();
        return sortByName;
    }

    public List<Customer> sortedId(){
        List<Customer> sortById = customers.stream()
                .sorted(Comparator.comparing(Customer::getId))
                .toList();
        return sortById;
    }

    public void listCustomersAccountInvoice(){
        for(Customer customer : customers){
            System.out.println(customer.getName());
            System.out.println(customer.getGender());

            List<Invoice> customerInvoices = invoices.stream()
                    .filter(i -> i.getCustomer().getId() == customer.getId())
                    .collect(Collectors.toList());

            Account account = accounts.stream()
                    .filter(a -> a.getCustomer().getId() == customer.getId())
                    .findFirst().orElse(null);

            if(account != null){
                System.out.println("Account balance: " + account.getBalance());
            }else{
                System.out.println("Account not found");
            }
            double totalAmountDue = 0;
            if(!customerInvoices.isEmpty()){
                for(Invoice invoice : customerInvoices){
                    double totalAmount = invoice.getAmount() * (1 - (double) customer.getDiscount() / 100);
                    if(customer.getGender() == Gender.FEMALE && invoice.getDatetime().getMonthValue() == 9 ){
                        System.out.println("Sale off 10%");
                        totalAmount *= 0.90;
                    }
                    totalAmountDue += totalAmount;
                    System.out.println("Invoice ID: " + invoice.getId() +
                            ", Amount: " + invoice.getAmount() +
                            ", Date: " + invoice.getDatetime());
                    System.out.println("Discount: " + customer.getDiscount() + "% Total amount after discount: " + totalAmount);

                    if (totalAmount > account.getBalance()) {
                        System.out.println("Your account does not have enough funds to pay!");
                    } else {
                        System.out.println("Successfully! ");
                    }
                }
                System.out.println("Total amount due for all invoices: " + totalAmountDue);
            }else {
                System.out.println("No invoices found for this customer.");
            }
        }
    }

}
