package Entity;

public class Account {
    private int id;
    private double balance;
    private Customer customer;

    public Account() {
    }

    public Account(int id, double balance, Customer customer) {
        this.id = id;
        this.balance = balance;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
