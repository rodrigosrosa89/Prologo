package com.project.prologo.services;

import com.project.prologo.entities.SaleEntity;
import com.project.prologo.repository.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmsService {
    @Autowired
    private SaleRepository repository;

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    public void sendSms(Long id) throws Exception {
        SaleEntity saleEntity;
        Optional<SaleEntity> optionalSale = repository.findById(id);
        if (optionalSale.isPresent()) {
            saleEntity = optionalSale.get();
        } else {
            throw new Exception("Venda com id " + id + " não localizado, gentileza verificar");
        }

        String date = saleEntity.getDate().getMonthValue() + "/" + saleEntity.getDate().getYear();
        String msg = "Vendedor " + saleEntity.getSellerName() + " foi destaque em     " +
                date + " com um total de R$ " + String.format("%.2f", saleEntity.getAmount());
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, "Prólogo - Gerenciador de produtos - " + msg).create();

        System.out.println(message.getSid());
    }

}
