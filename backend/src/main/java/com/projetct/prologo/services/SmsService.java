package com.projetct.prologo.services;

import com.projetct.prologo.entities.Sale;
import com.projetct.prologo.repository.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
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
        Sale sale = null;
        Optional<Sale> optionalSale = repository.findById(id);
        if (optionalSale.isPresent()) {
            sale = optionalSale.get();
        } else {
            throw new Exception("Venda com id " + id + " não localizado, gentileza verificar");
        }

        String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
        String msg = "Vendedor " + sale.getSellerName() + " foi destaque em     " +
                date + " com um total de R$ " + String.format("%.2f", sale.getAmount());
        Twilio.init(twilioSid, twilioKey);

        PhoneNumber to = new PhoneNumber(twilioPhoneTo);
        PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

        Message message = Message.creator(to, from, "Prólogo - Gerenciador de produtos - " + msg).create();

        System.out.println(message.getSid());
    }

}
