package Controller;

import Entity.Invoice;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InvoiceController {
    private List<Invoice> invoices;

    public InvoiceController(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public List<Invoice> sortedByCustomerName() {
        return invoices.stream()
                .sorted(Comparator.comparing(i -> i.getCustomer().getName()))
                .collect(Collectors.toList());
    }

    public Optional <Invoice> getById(int keyword){
        return invoices.stream()
                .filter(i -> i.getId() == keyword)
                .findFirst();
    }


}
