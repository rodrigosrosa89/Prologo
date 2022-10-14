package com.projetct.prologo.controllers;

import com.projetct.prologo.entities.Sale;
import com.projetct.prologo.services.SaleService;
import com.projetct.prologo.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    SaleService saleService;

    @Autowired
    SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                Pageable pageable) {
        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping(value = "/notification/{id}")
    public void notifySms(@PathVariable Long id) throws Exception {
        smsService.sendSms(id);
    }
}
