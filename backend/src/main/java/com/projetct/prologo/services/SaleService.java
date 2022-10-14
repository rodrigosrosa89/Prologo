package com.projetct.prologo.services;

import com.projetct.prologo.entities.Sale;
import com.projetct.prologo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }

    public Sale findSaleById(Long id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isPresent()) {
            return optionalSale.get();
        }
        return null;
    }

    public void createSale(Sale sale) {
        saleRepository.save(sale);
    }

}
