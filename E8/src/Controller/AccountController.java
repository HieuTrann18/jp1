package Controller;

import Entity.Account;
import Service.AccountService;

import java.util.List;

public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    public Account getAccountByCustomerCode(String code) {
        return accountService.getAccountByCustomerCode(code);
    }

    public Account getAccountByCustomerName(String keyword) {
        return accountService.getAccountByCustomerName(keyword);
    }

    public List<Account> getAccountByCustomer(){
        return accountService.getAccountByCustomer();
    }

    public long countAccountByCustomer(){
        return accountService.countAccountByCustomer();
    }

    public Account getMaxBalanceFemale(){
        return accountService.getMaxBalance();
    }
}
