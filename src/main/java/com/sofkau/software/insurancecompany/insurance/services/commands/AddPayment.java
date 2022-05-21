package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class AddPayment extends Command {

    private final ServicesId servicesId;
    private final DisResId disResId;
    private final Payments payment;

    public AddPayment(ServicesId servicesId, DisResId disResId, Payments payment) {
        this.servicesId = servicesId;
        this.disResId = disResId;
        this.payment = payment;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisResId disResId() {
        return disResId;
    }

    public Payments payment() {
        return payment;
    }
}
