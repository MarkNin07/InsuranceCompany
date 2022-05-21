package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class SendPayment extends Command {

    private final ServicesId servicesId;
    private final DisResId disResId;
    private final Payments payments;

    public SendPayment(ServicesId servicesId, DisResId disResId, Payments payments) {
        this.servicesId = servicesId;
        this.disResId = disResId;
        this.payments = payments;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisResId disResId() {
        return disResId;
    }

    public Payments payments() {
        return payments;
    }
}
