package com.nsbm.xyzhotel.service;

import xyzhotel.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

    public String Save(PaymentMethod paymentMethod);

    public String Update(PaymentMethod paymentMethod);

    public PaymentMethod FindById(int id);

    public List<PaymentMethod> FindAll();
}
