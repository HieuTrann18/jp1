package Controller;

import Entity.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountController {
    private List<Account> accounts;
    public AccountController(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Optional<Account> searchAccount(String keyword) {
            Optional<Account> accountResult = accounts.stream()
                    .filter(a -> a.getCustomer().getName().equalsIgnoreCase(keyword) ||
                            String.valueOf(a.getId()).equals(keyword))
                    .findFirst();

            return accountResult;
    }
}
