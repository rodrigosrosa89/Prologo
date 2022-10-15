package com.project.prologo.services;

import com.project.prologo.entities.SaleEntity;
import com.project.prologo.repository.SaleRepository;
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

    public Page<SaleEntity> findSales(String minDate, String maxDate, Pageable pageable) {
        if (!Strings.isBlank(minDate) && !Strings.isBlank(maxDate)) {
            LocalDate minLocalDate = LocalDate.parse(minDate);
            LocalDate maxLocalDate = LocalDate.parse(maxDate);

            return repository.findSales(minLocalDate, maxLocalDate, pageable);
        } else {
            return repository.findAll(pageable);
        }
    }

    public SaleEntity findSaleById(Long id) {
        Optional<SaleEntity> optionalSale = repository.findById(id);
        return optionalSale.orElse(null);
    }

    public void save(SaleEntity saleEntity) {
        repository.save(saleEntity);
    }

    public void delete(SaleEntity saleEntity) {
        repository.delete(saleEntity);
    }


}
