package Controller;
import Entity.Account;
import Service.TransactionService;

public class AccountController extends TransactionService{
    private static Account acc;
    public AccountController(Account acc){
        AccountController.acc = acc;
    }
    @Override
    public void deposit(double amount){
            acc.setBalance(acc.getBalance() + amount);
    }
    @Override
    public void withdraw(double amount){
            acc.setBalance(acc.getBalance() - amount);
    }

}
