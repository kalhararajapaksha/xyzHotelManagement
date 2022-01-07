package com.nsbm.xyzhotel.controller;

import com.nsbm.xyzhotel.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyzhotel.model.Payment;
import xyzhotel.model.Responsehandle.Response;
import xyzhotel.model.exception.InvalidPaymentMethodException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Response savePayment(@RequestBody Payment payment) {
        try {
            payment = paymentService.Save(payment);
            return Response.success(payment);
        } catch (InvalidPaymentMethodException invalidPaymentMethodException) {
            return Response.fail(invalidPaymentMethodException);
        }
    }
}
