package com.nsbm.xyzhotel.service;

import xyzhotel.model.Payment;

import java.util.List;

public interface PaymentService {

    public Payment Save(Payment payment);

    public String Update(Payment payment);

    public Payment FindById(int id);

    public List<Payment> FindAll();
}
