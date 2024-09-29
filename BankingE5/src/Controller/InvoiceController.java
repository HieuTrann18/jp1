package Controller;

import Entity.Invoice;

import java.util.List;
import java.util.Optional;

public class InvoiceController {
    private List<Invoice> invoices;
    public InvoiceController(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public Optional <Invoice> searchInvoice(String keyword){
        Optional<Invoice> InvoiceResult = invoices.stream()
                .filter(i -> i.getCustomer().getName().equalsIgnoreCase(keyword) ||
                        String.valueOf(i.getId()).equals(keyword))
                .findFirst();
        return InvoiceResult;
    }
}
