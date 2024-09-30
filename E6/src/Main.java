import Entity.CurrentAccount;
import Entity.SavingAccount;



public class Main {
    public static void main(String[] args) {
        double ibal, damt, wamt;
        ibal = 1000.00;
        SavingAccount savingaccount = new SavingAccount("SA001", 1000.00);
        System.out.println("Saving A/c: Initial Balace: $" + ibal);

        damt = 500.00;
        savingaccount.deposit(damt);

        wamt = 250.00;
        savingaccount.withdraw(wamt);

        wamt = 1600.00;
        System.out.println("\nTry to withdraw: $" + wamt);
        savingaccount.withdraw(wamt);
        System.out.println();

        ibal = 5000.00;

        CurrentAccount currentaccount = new CurrentAccount("CA001", 5000.00);
        System.out.println("Current A/c: Initial Balace: $" + ibal);
        damt = 250.00;

        currentaccount.deposit(1000.0);
        wamt = 1250.00;

        currentaccount.withdraw(3000.0);
        wamt = 6000.00;
        System.out.println("\nTry to withdraw: $" + wamt);
        savingaccount.withdraw(wamt);
    }
}