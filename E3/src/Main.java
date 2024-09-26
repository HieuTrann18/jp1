
import java.util.*;
import java.util.stream.Collectors;

import Entity.Customer;
import Entity.Invoice;



public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<Customer>();
        customers.add(new Customer(1, "Hieu", 60));
        customers.add(new Customer(2, "Vinh", 20));
        customers.add(new Customer(3, "Quang", 30));
        customers.add(new Customer(4, "Duy", 10));

        List<Invoice> invoices = new ArrayList<Invoice>();
        invoices.add(new Invoice(1, customers.get(0), 800000));
        invoices.add(new Invoice(2, customers.get(1), 400000));
        invoices.add(new Invoice(3, customers.get(2), 200000));
        invoices.add(new Invoice(4, customers.get(3), 300000));

        for(Customer c : customers){
            System.out.println(c);
        }

        System.out.println("=================================================");

        for(Invoice i : invoices){
            System.out.println(i);
        }


        //Example 1
        int idCustomer = 2;
        List <Invoice> invoiceCustomer = invoices.stream()
                .filter(p -> p.getCustomer().getId() == idCustomer)
                .toList();
        System.out.println("Đây là hóa đơn theo id của khách hàng");
        for(Invoice i : invoiceCustomer){
            System.out.println(i);
        }

        Optional<Invoice> maxInvoice = invoices.stream()
                .max(Comparator.comparingDouble(Invoice::getAmount));
        System.out.println("This is max amount of the customer");
        maxInvoice.ifPresent(System.out::println);

        Optional<Customer> minDiscount = customers.stream()
                .min(Comparator.comparingDouble(Customer::getDiscount));
        System.out.println("This is min discount of the customer");
        minDiscount.ifPresent(System.out::println);





        //Example 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào id hoặc tên của khách hàng: ");
        String input = scanner.nextLine();

        if(!input.isEmpty()) {
            if(isNumeric(input)) {
                int CustomerId = Integer.parseInt(input);

                List<Invoice> invoiceCus = invoices.stream()
                        .filter(p -> p.getId() == CustomerId)
                        .toList();
                if(invoiceCus.isEmpty()){
                    System.out.println("Không tìm thấy hóa đơn với ID này");
                }else{
                    System.out.println("Kết quả tìm kiếm theo ID hóa đơn: ");
                    invoiceCus.forEach(System.out::println);
                }
            }else{
                List<Invoice> resultByName = invoices.stream()
                        .filter(p -> p.getCustomer().getName().equalsIgnoreCase(input))
                        .collect(Collectors.toList());
                if(resultByName.isEmpty()){
                    System.out.println("Không tìm thấy khách hàng theo đơn này");
                }else{
                    System.out.println("Kết quả tìm kiếm theo tên khách hàng: ");
                    resultByName.forEach(System.out::println);
                }
            }

        }else{

            System.out.println("Input không được để trống.");
        }
    }

    public static boolean isNumeric(String str){
        if(str == null || str.isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }


}