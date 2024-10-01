package Service;
import Entity.Account;
import Controller.AccountController;

public class ValidationService {
    private static Account acc;
    private static AccountController action;
    public static void depositvalidate(double amount){
        if(amount > 0){
            action.deposit(amount);
            System.out.println("Gui tien thanh cong");
        }else{
            System.out.println("Gui tien that bai");
            return;
        }
    }
    protected static void withdrawvalidate(double amount){
        if(amount > 0 && amount <= acc.getBalance()){
            action.withdraw(amount);
            System.out.println("Rut tien thanh cong");
        }else{
            System.out.println("Rut tien that bai");
            return;
        }
    }
}