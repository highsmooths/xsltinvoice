package com.kolaysoft.first.invoicexslt.invoices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoices, Integer> {
    List<Invoices> findByUsername(String username);
}
