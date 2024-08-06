package com.kolaysoft.first.invoicexslt.invoices;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class InvoiceControllerJpa {

    private final InvoiceRepository invoiceRepository;

    public InvoiceControllerJpa(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @RequestMapping("list-invoices")
    public String listAllInvoices(ModelMap model) {
        String username = getLoggedInUsername();
        List<Invoices> invoices = invoiceRepository.findByUsername(username);
        model.addAttribute("invoices", invoices);
        return "listInvoices";
    }

    private String getLoggedInUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
