package com.nsbm.xyzhotel.service;

import xyzhotel.model.PaymentLine;

import java.util.List;

public interface PaymentLineService {

    public String Save(PaymentLine paymentLine);

    public String Update(PaymentLine paymentLine);

    public PaymentLine FindById(int id);

    public List<PaymentLine> FindAll();
}
