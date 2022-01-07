package com.nsbm.xyzhotel.service.impl;

import com.nsbm.xyzhotel.repository.PaymentRepository;
import com.nsbm.xyzhotel.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyzhotel.model.Payment;
import xyzhotel.model.exception.InvalidPaymentMethodException;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment Save(Payment payment) {
        if(payment.getReservationID() == 0){
            throw new InvalidPaymentMethodException("Cant empty ReservationID");
        }
        payment = paymentRepository.save(payment);
        return payment;
    }

    @Override
    public String Update(Payment payment) {
        return null;
    }

    @Override
    public Payment FindById(int id) {
        return null;
    }

    @Override
    public List<Payment> FindAll() {
        return null;
    }
}
