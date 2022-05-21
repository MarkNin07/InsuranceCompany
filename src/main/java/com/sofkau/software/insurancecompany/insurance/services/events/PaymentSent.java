package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;

public class PaymentSent extends DomainEvent {

    private final DisResId disResId;
    private final Payments payment;

    public PaymentSent(DisResId disResId, Payments payment) {
        super("marconino.services.paymentsent");
        this.disResId = disResId;
        this.payment = payment;
    }

    public DisResId getDisResId() {
        return disResId;
    }

    public Payments getPayment() {
        return payment;
    }
}
