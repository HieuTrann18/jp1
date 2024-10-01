import Controller.AccountController;
import Entity.*;
import Service.ValidationService;

import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customer = new ArrayList<>();
        customer.add(new Customer(1, "Son"));
        customer.add(new Customer(2, "Vinh"));
        Account acc = new Account("12345678", customer.get(0), 2000);
        AccountController accountController = new AccountController(acc);
        accountController.deposit(120);
        System.out.println(acc);
        accountController.withdraw(2200);
        System.out.println(acc);

    }
}
