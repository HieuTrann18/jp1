package Service;

import Entity.Account;
import IGeneric.IGeneral;

import java.util.Comparator;
import java.util.List;
import Global.Global;

public class AccountService implements IGeneral<Account> {
    private List<Account> accounts;

    public AccountService(List<Account> accounts){
        this.accounts = accounts;
    }

    @Override
    public void update(Account object) {
        accounts.stream()
                .filter(a -> a.getId() == object.getId())
                .forEach(a -> {
                    a.getCustomer().setName(object.getCustomer().getName());
                    a.getCustomer().setDiscount(object.getCustomer().getDiscount());
                    a.setBalance(object.getBalance());
                });
    }

    @Override
    public List<Account> sort() {
        return accounts.stream()
                .sorted(Comparator.comparing(a -> a.getCustomer().getName()))
                .toList();
    }

    @Override
    public List<Account> getById(int id) {
        return accounts.stream()
                .filter(a -> a.getId() == id)
                .toList();
    }

    @Override
    public List<Account> getByName(String name) {
        return accounts.stream()
                .filter(a -> Global.ignoreCase(a.getCustomer().getName(), name))
                .toList();
    }
}
