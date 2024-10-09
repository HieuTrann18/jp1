package Entity;

import java.time.LocalDate;

public class Invoice {
    private int id;
    private double amount;
    private Customer customer;
    private LocalDate datetime;

    public Invoice() {
    }

    public Invoice(int id, double amount, Customer customer, LocalDate datetime) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
        this.datetime = datetime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    public double getAmountAfterDiscount() {
        return amount * (1 - customer.getDiscount() / 100.0);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", amount=" + amount +
                ", customer=" + customer +
                ", datetime=" + datetime +
                '}';
    }
}
