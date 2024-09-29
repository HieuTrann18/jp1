import Controller.AccountController;
import Controller.CustomerController;
import Controller.InvoiceController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Invoice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "John Doe", Gender.MALE, 10));
        customers.add(new Customer(2, "Jane Doe", Gender.FEMALE, 15));
        customers.add(new Customer(3, "Alex Smith", Gender.MALE, 20));

        // Tạo danh sách Account
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, customers.get(0), 1000.0));
        accounts.add(new Account(2, customers.get(1), 1500.5));
        accounts.add(new Account(3, customers.get(2), 3000.75));

        // Tạo danh sách Invoice
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, customers.get(0), 500.0, LocalDateTime.now()));
        invoices.add(new Invoice(2, customers.get(1), 750.5, LocalDateTime.now()));
        invoices.add(new Invoice(3, customers.get(2), 1000.25, LocalDateTime.now()));
        invoices.add(new Invoice(4, customers.get(2), 1100.25, LocalDateTime.now()));

        CustomerController customerController = new CustomerController(customers, accounts, invoices);
        AccountController accountController = new AccountController(accounts);
        InvoiceController invoiceController = new InvoiceController(invoices);

        Scanner scanner = new Scanner(System.in);
        int choose;

        do{
            System.out.println("Lua chon cua ban:");
            System.out.println("1. Sort by name");
            System.out.println("2. Sort by id");
            System.out.println("3. Search Account by Id or name");
            System.out.println("4. Search Invoice by Id or name");
            System.out.println("5. Display invoice after payment");
            System.out.println("0. Exit");
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Sort by name: ");
                    List<Customer> sortedCustomer = customerController.sortedName();
                    for(Customer customer : sortedCustomer){
                        System.out.println(customer);
                    }
                    break;
                case 2:
                    System.out.println("Sort by id: ");
                    List<Customer> sortedCustomerId = customerController.sortedId();
                    for(Customer customerId : sortedCustomerId){
                        System.out.println(customerId);
                    }
                    break;
                case 3:
                    System.out.println("Search Account by Id or name: ");
                    scanner.nextLine();
                    String keyword = scanner.nextLine();
                    Optional<Account> searchResults = accountController.searchAccount(keyword);
                    if(searchResults.isPresent()){
                        System.out.println("----------------------------------------------------------");
                        System.out.println("Account ID: " + searchResults.get().getId() +
                                           ", Customer Name: " + searchResults.get().getCustomer().getName() +
                                           ", Balance " + searchResults.get().getBalance());
                        System.out.println("----------------------------------------------------------");
                    }else{
                        System.out.println("Account ID or Name not found");
                    }
                    break;
                case 4:
                    System.out.println("Search Invoice by Id or name: ");
                    scanner.nextLine();
                    String keyword2 = scanner.nextLine();
                    Optional<Invoice> searchResult = invoiceController.searchInvoice(keyword2);
                    if(searchResult.isPresent()){
                        System.out.println("------------------------------------------------------------");
                        System.out.println("Invoice ID: " + searchResult.get().getId() +
                                           ", Customer Name: " + searchResult.get().getCustomer().getName()+
                                           ", Amount: " + searchResult.get().getAmount() +
                                           ", Date: " + searchResult.get().getDatetime());
                        System.out.println("------------------------------------------------------------");
                    }else{
                        System.out.println("Invoice ID or Name not found");
                    }
                    break;
                case 5:
                    System.out.println("Display customer invoice and account information: ");
                    customerController.listCustomersAccountInvoice();
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }while(choose != 0);

//        CustomerController customerController = new CustomerController(customers, accounts, invoices);
//        customerController.listCustomersAccountInvoice();

    }
}