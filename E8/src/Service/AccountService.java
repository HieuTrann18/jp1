package Service;

import Entity.Account;
import Entity.Gender;
import Global.Global;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static Entity.Gender.FEMALE;
import static Entity.Gender.MALE;

public class AccountService {
    private final List<Account> acc;
    public AccountService(List<Account> acc) {
        this.acc = acc;
    }

    public List<Account> getAcc() {
        return acc;
    }

    public Account getAccountByCustomerCode(String code){
        Optional <Account> account = acc.stream()
                .filter(a -> a.getCustomer().getCode().equalsIgnoreCase(code))
                .findFirst();
        if(account.isPresent()){
            return account.get();
        }else{
            return null;
        }
    }

    public Account getAccountByCustomerName(String keyword){
        Optional <Account> account = acc.stream()
                .filter(a -> Global.ignoreCase(a.getCustomer().getName(), keyword))
                .findFirst();
        if(account.isPresent()){
            return account.get();
        }else{
            return null;
        }
    }

    public List<Account> getAccountByCustomer(){
        return acc.stream()
                .filter(a -> a.getCustomer().getGender() == MALE && a.getBalance() > 1000000)
                .toList();
    }

    public long countAccountByCustomer(){
        acc.stream()
                .filter(a -> a.getCustomer().getGender() == FEMALE && a.getBalance() > 100000)
                .forEach(a -> {
                    System.out.println("Customer: " + a.getCustomer().getName() +
                                       ", Balance: " + a.getBalance());
                });
                return acc.stream()
                        .filter(a -> a.getCustomer().getGender() == Gender.FEMALE && a.getBalance() > 100000)
                        .count();
    }

    public Account getMaxBalance(){
        return acc.stream()
                .filter(a -> a.getCustomer().getGender() == FEMALE)
                .max(Comparator.comparing(Account::getBalance))
                .orElse(null);
    }
}
