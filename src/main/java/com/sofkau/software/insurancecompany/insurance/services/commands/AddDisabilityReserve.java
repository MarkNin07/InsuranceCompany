package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class AddDisabilityReserve extends Command {

    private final ServicesId servicesId;
    private final DisResId disResId;
    private final IsDisabled isDisabled;
    private final Payments payments;

    public AddDisabilityReserve(ServicesId servicesId, DisResId disResId, IsDisabled isDisabled, Payments payments) {
        this.servicesId = servicesId;
        this.disResId = disResId;
        this.isDisabled = isDisabled;
        this.payments = payments;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisResId disResId() {
        return disResId;
    }

    public IsDisabled disabled() {
        return isDisabled;
    }

    public Payments payments() {
        return payments;
    }
}
