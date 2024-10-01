package Service;

public abstract class TransactionService {
    public abstract void deposit(double amount);
    protected abstract void withdraw(double amount);
}
