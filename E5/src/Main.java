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

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = initializeCustomers();
        List<Account> accounts = initializeAccounts(customers);
        List<Invoice> invoices = initializeInvoices(customers);
        CustomerController customerController = new CustomerController(customers, accounts, invoices);
        AccountController accountController = new AccountController(accounts);
        InvoiceController invoiceController = new InvoiceController(invoices);

        displaySortedData(customerController, accountController, invoiceController);

        try (Scanner scanner = new Scanner(System.in)) {
            searchCustomerByName(scanner, customerController);
            searchCustomerById(scanner, customerController);
            searchInvoiceById(scanner, invoiceController);
        }

        customerController.listCustomerAccountInvoice();
    }

    private static List<Customer> initializeCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(1, "Tran The Hieu", Gender.MALE, 8));
        customers.add(new Customer(2, "Nguyen Ngoc Vinh", Gender.MALE, 7));
        customers.add(new Customer(3, "Nguyen Quang Dat", Gender.MALE, 4));
        customers.add(new Customer(4, "Nguyen Thuy Duong", Gender.FEMALE, 9));
        customers.add(new Customer(5, "Ngo Nhat Mai", Gender.FEMALE, 15));
        return customers;
    }

    private static List<Account> initializeAccounts(List<Customer> customers) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account(1, customers.get(0), 10000.0));
        accounts.add(new Account(2, customers.get(1), 15000.0));
        accounts.add(new Account(3, customers.get(2), 250.000));
        accounts.add(new Account(4, customers.get(3), 5000.0));
        accounts.add(new Account(5, customers.get(4), 80000.0));
        return accounts;
    }

    private static List<Invoice> initializeInvoices(List<Customer> customers) {
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, customers.get(0), 80.000, LocalDateTime.now()));
        invoices.add(new Invoice(2, customers.get(1), 53.000, LocalDateTime.now()));
        invoices.add(new Invoice(3, customers.get(2), 300.000, LocalDateTime.now()));
        invoices.add(new Invoice(4, customers.get(3), 15.000, LocalDateTime.now()));
        invoices.add(new Invoice(5, customers.get(4), 32.000, LocalDateTime.now()));
        return invoices;
    }

    private static void displaySortedData(CustomerController customerController, AccountController accountController, InvoiceController invoiceController) {
        System.out.println("Customers sorted by name:");
        customerController.sortedByCustomerName().forEach(System.out::println);

        System.out.println("\nAccounts sorted by customer name: ");
        accountController.sortedByCustomerName().forEach(System.out::println);

        System.out.println("\nInvoices sorted by customer name: ");
        invoiceController.sortedByCustomerName().forEach(System.out::println);
    }

    private static void searchCustomerByName(Scanner scanner, CustomerController customerController) {
        System.out.print("Nhập từ khóa để tìm kiếm khách hàng: ");
        String searchKeyword = scanner.nextLine();

        customerController.searchByName(searchKeyword).ifPresentOrElse(
                customer -> System.out.println("Đã tìm thấy khách hàng: " + customer),
                () -> System.out.println("Không tìm thấy khách hàng: " + searchKeyword)
        );
    }

    private static void searchCustomerById(Scanner scanner, CustomerController customerController) {
        System.out.print("Nhập Id để tìm kiếm khách hàng: ");
        String searchId = scanner.nextLine();

        try {
            int id = Integer.parseInt(searchId);
            customerController.searchById(id).ifPresentOrElse(
                    customer -> System.out.println("Đã tìm thấy khách hàng: " + customer),
                    () -> System.out.println("Không tìm thấy khách hàng: " + searchId)
            );
        } catch (NumberFormatException e) {
            System.out.println("ID không hợp lệ. Vui lòng nhập vào là một số.");
        }
    }

    private static void searchInvoiceById(Scanner scanner, InvoiceController invoiceController) {
        System.out.print("Nhập id để tìm kiếm hóa đơn: ");
        int id = scanner.nextInt();
        invoiceController.getById(id).ifPresentOrElse(
                invoiceId -> System.out.println("Đã tìm thấy hóa đơn với id: " + invoiceId),
                () -> System.out.println("Không tìm thấy hóa đơn: " + id)
        );
    }
}
