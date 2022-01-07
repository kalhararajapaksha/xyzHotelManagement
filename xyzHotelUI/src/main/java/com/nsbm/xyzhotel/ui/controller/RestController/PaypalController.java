package com.nsbm.xyzhotel.ui.controller.RestController;

import com.nsbm.xyzhotel.ui.model.Order;
import com.nsbm.xyzhotel.ui.service.PaypalService;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class PaypalController {

    @Autowired
    PaypalService paypalService;

    public static final String SUCCESS_URL = "pay/success";
    public static final String CANCEL_URL = "pay/cancel";


    @PostMapping("/pay")
    public String payment(@RequestBody Map map) {
        String currency = map.get("currency").toString();
        String method = map.get("method").toString();
        String intent = map.get("intent").toString();
        String description = map.get("description").toString();
        Double price =Double.parseDouble(map.get("price").toString());

        Order order = new Order();
        order.setPrice(price);
        order.setCurrency(currency);
        order.setMethod(method);
        order.setIntent(intent);
        order.setDescription(description);

        try {
            Payment payment = paypalService.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
                    order.getIntent(), order.getDescription(), "http://localhost:9191/" + CANCEL_URL,
                    "http://localhost:9191/" + SUCCESS_URL);
            for(Links link:payment.getLinks()) {
                if(link.getRel().equals("approval_url")) {
                    return "redirect:"+link.getHref();
                }
            }

        } catch (PayPalRESTException e) {

            e.printStackTrace();
        }
        return "redirect:/";
    }

    @GetMapping(value = CANCEL_URL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(value = SUCCESS_URL)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            System.out.println(payment.toJSON());
            if (payment.getState().equals("approved")) {
                return "success";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }

    @PostMapping
    public String helloo(@RequestBody Map map){

        return "Helloo";
    }

}
