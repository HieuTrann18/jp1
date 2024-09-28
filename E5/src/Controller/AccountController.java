package Controller;

import Entity.Account;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AccountController {
    private List<Account> accounts;

    public AccountController(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> sortedByCustomerName() {
        return accounts.stream()
                .sorted(Comparator.comparing(a -> a.getCustomer().getName()))
                .collect(Collectors.toList());
    }
}
