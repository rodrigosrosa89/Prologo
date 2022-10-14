package com.projetct.prologo.services;

import com.projetct.prologo.entities.Sale;
import com.projetct.prologo.repository.SaleRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
        if (!Strings.isBlank(minDate) && !Strings.isBlank(maxDate)) {
            LocalDate minLocalDate = LocalDate.parse(minDate);
            LocalDate maxLocalDate = LocalDate.parse(maxDate);

            return repository.findSales(minLocalDate, maxLocalDate, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    public Sale findSaleById(Long id) {
        Optional<Sale> optionalSale = repository.findById(id);
        if (optionalSale.isPresent()) {
            return optionalSale.get();
        }
        return null;
    }

    public void createSale(Sale sale) {
        repository.save(sale);
    }

}
