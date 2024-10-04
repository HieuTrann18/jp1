import Controller.AccountController;
import Controller.CustomerController;
import Controller.StaffController;
import Entity.Account;
import Entity.Customer;
import Entity.Gender;
import Entity.Staff;
import Service.AccountService;
import Service.CustomerService;
import Service.StaffService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();
        List<Staff> staffs = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();


        CustomerService cs = new CustomerService(customers);
        StaffService ss = new StaffService(staffs);
        AccountService as = new AccountService(accounts);


        CustomerController customerController = new CustomerController(cs);
        StaffController staffController = new StaffController(ss);
        AccountController accountController = new AccountController(as);


        staffs.add(new Staff(1, "B001", "Hieu", LocalDateTime.now()));
        staffs.add(new Staff(2, "B002", "Long", LocalDateTime.now()));


        customers.add(new Customer(1, "VCB01", "Binh", Gender.MALE));
        customers.add(new Customer(2, "TCB02", "Vinh", Gender.FEMALE));
        customers.add(new Customer(3, "TCB03", "Long", Gender.FEMALE));


        accounts.add(new Account(1, "1B2C4", 1200000, LocalDateTime.now(), customers.get(0))); // sửa chỉ số để đúng với khách hàng
        accounts.add(new Account(2, "1B2C12", 130000, LocalDateTime.now(), customers.get(1)));
        accounts.add(new Account(3, "1B2C123", 140000, LocalDateTime.now(), customers.get(2)));

//
        Customer cus = customerController.getById(1);
        if(cus != null){
            System.out.println("Customer found: " + cus);
        } else {
            System.out.println("Customer not found");
        }


        Staff staff = staffController.getById(1);
        if(staff != null){
            System.out.println("Staff found: " + staff);
        } else {
            System.out.println("Staff not found");
        }


        String code = "VCB01";
        Account account = accountController.getAccountByCustomerCode(code);
        if(account != null){
            System.out.println("Account found: " + account);
        } else {
            System.out.println("Account not found");
        }

        String keyword = "Binh";
        Account accs = accountController.getAccountByCustomerName(keyword);
        if(accs != null){
            System.out.println("Account found: " + accs);
        }else{
            System.out.println("Account not found");
        }

        List<Account> maleAcc = accountController.getAccountByCustomer();
        System.out.println("Thong tin khach hang co gioi tinh la nam va so du > 1.000.000 la: ");
        for(Account acc : maleAcc){
            if(acc != null){
                System.out.println(acc);
            }else{
                System.out.println("Not Fount");
            }

        }

        long femaleAcc = accountController.countAccountByCustomer();
        System.out.println("Thong tin khach hang co gioi tinh la nu va so du > 100.000 la: " + femaleAcc);


        Account maxBalanceFemale = accountController.getMaxBalanceFemale();
        if(maxBalanceFemale != null){
            System.out.println("Khach hang nu co so du lon nhat la: " + maxBalanceFemale);
        }else{
            System.out.println("Khong tim thay khach hang nao co so du lon nhat la nu");
        }

    }
}
