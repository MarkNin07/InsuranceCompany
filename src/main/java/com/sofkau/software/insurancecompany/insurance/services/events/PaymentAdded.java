package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class PaymentAdded extends DomainEvent {


    private final ServicesId servicesId;
    private final DisResId disResId;
    private final Payments payment;

    public PaymentAdded(ServicesId servicesId, DisResId disResId, Payments payment) {
        super("marconino.services.paymentadded");
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
