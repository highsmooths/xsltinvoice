package com.kolaysoft.first.invoicexslt.invoices;

import com.kolaysoft.first.invoicexslt.util.XmlUtils;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class InvoiceService {

    private static List<Invoices> invoices = new ArrayList<>();

    private static int invoicesCount = 0;

    static {
        invoices.add(new Invoices(++invoicesCount, "John Doe", "Website Development",
                LocalDate.now().plusYears(1), false));
        invoices.add(new Invoices(++invoicesCount, "Jane Smith", "Graphic Design",
                LocalDate.now().plusYears(2), false));
        invoices.add(new Invoices(++invoicesCount, "Acme Corp", "Software Development",
                LocalDate.now().plusYears(3), false));
    }

    public List<Invoices> findByUsername(String username) {
        Predicate<? super Invoices> predicate =
                invoice -> invoice.getUsername().equalsIgnoreCase(username);
        return invoices.stream().filter(predicate).toList();
    }

    public void addInvoice(String username, String description, LocalDate targetDate, boolean done) {
        Invoices invoice = new Invoices(++invoicesCount, username, description, targetDate, done);
        invoices.add(invoice);
    }

    public void deleteById(int id) {
        Predicate<? super Invoices> predicate = invoice -> invoice.getId() == id;
        invoices.removeIf(predicate);
    }

    public Invoices findById(int id) {
        Predicate<? super Invoices> predicate = invoice -> invoice.getId() == id;
        return invoices.stream().filter(predicate).findFirst().orElse(null);
    }

    public void updateInvoice(@Valid Invoices invoice) {
        deleteById(invoice.getId());
        invoices.add(invoice);
    }

    public String getInvoicesAsXml() throws IOException, TransformerException {
        return XmlUtils.convertObjectToXml(invoices);
    }
}
