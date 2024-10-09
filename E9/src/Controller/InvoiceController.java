package Controller;

import Entity.Account;
import Entity.Customer;
import Entity.Invoice;
import Service.InvoiceService;

import java.util.List;

public class InvoiceController {
    private List<Invoice> invoices;
    private InvoiceService is;

    public InvoiceController(InvoiceService is){
        this.is = is;
    }

    public void totalAmountInvoice(int id) {
        double totalAmount = is.totalAmountInvoice(id);
        if (totalAmount > 0) {
            List<Invoice> ivc = is.getById(id);
            if (!ivc.isEmpty()) {
                String customerName = ivc.get(0).getCustomer().getName();
                System.out.println("Name: " + customerName);
                for (Invoice i : ivc) {
                    System.out.println("Id: " + i.getId() +
                            ", Amount: " + i.getAmount() +
                            ", Date: " + i.getDatetime()) ;
                }
                System.out.println("Total amount after discount: " + totalAmount);
            }
        } else {
            System.out.println("No invoices found for customer ID " + id);
        }
    }
}
