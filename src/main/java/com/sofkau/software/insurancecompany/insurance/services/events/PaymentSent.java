package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class PaymentSent extends DomainEvent {

    private final ServicesId servicesId;
    private final DisResId disResId;
    private final Payments payment;

    public PaymentSent(ServicesId servicesId, DisResId disResId, Payments payment) {
        super("marconino.services.paymentsent");
        this.servicesId = servicesId;
        this.disResId = disResId;
        this.payment = payment;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisResId getDisResId() {
        return disResId;
    }

    public Payments getPayment() {
        return payment;
    }
}
