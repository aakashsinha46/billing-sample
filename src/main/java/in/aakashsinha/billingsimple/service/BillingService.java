package in.aakashsinha.billingsimple.service;

import in.aakashsinha.billingsimple.entity.Billing;
import in.aakashsinha.billingsimple.model.BillingModel;

import java.util.List;

public interface BillingService {

    public Billing addBilling(BillingModel billingModel);

    public List<Object> getAllBills();
}
