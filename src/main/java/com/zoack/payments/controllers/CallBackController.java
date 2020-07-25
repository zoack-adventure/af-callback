package com.zoack.payments.controllers;


import com.zoack.payments.models.Transaction;
import com.zoack.payments.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class CallBackController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment-response")
    public String response(@RequestBody Transaction transaction) throws ExecutionException, InterruptedException {
        System.out.println(transaction.getRequestMetadata());
        return paymentService.saveCallbackDetails(transaction);
    }

}
