package Entity;

public  class SavingAccount extends BankAccount {
    public SavingAccount() {}
    public SavingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
    @Override
    public String getAccountNumber() {
        return super.getAccountNumber();
    }

    @Override
    public void setAccountNumber(String accountNumber) {
        super.setAccountNumber(accountNumber);
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }

    @Override
    public void setBalance(double balance) {
        super.setBalance(balance);
    }

    @Override
    public void deposit(double amount) {
        if(amount > 0){
            this.setBalance(this.getBalance() + amount);
            System.out.println("Deposit of $ " + amount + ", Successful, Current Account Balance: " + this.getBalance());
        }else{
            System.out.println("Deposit Fail");
        }
    }

    @Override
    public void withdraw(double amount) {
        if(amount > 0){
            this.setBalance(this.getBalance() - amount);
            System.out.println("Withdraw of $ " + amount + ", Successful, Current account balance: " + this.getBalance());
        }else{
            System.out.println("Insufficient funds withdraw Fail");
        }
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "accountNumber='" + this.getAccountNumber() + '\'' +
                ", balance=" + this.getBalance() +
                "}";
    }

}
