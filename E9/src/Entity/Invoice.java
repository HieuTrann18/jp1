package Entity;

import java.time.LocalDateTime;

public class Invoice {
    private int id;
    private Customer customer;
    private double amount;
    private LocalDateTime dateTime;

    public Invoice() {
    }

    public Invoice(int id, Customer customer, double amount, LocalDateTime dateTime) {
        this.id = id;
        this.customer = customer;
        this.amount = amount;
        this.dateTime = dateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", customer=" + customer +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                '}';
    }
}

