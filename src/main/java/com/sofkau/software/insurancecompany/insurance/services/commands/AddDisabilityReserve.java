package com.sofkau.software.insurancecompany.insurance.services.commands;

import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;

public class AddDisabilityReserve {

    private final DisResId disResId;
    private final IsDisabled isDisabled;
    private final Payments payments;

    public AddDisabilityReserve(DisResId disResId, IsDisabled isDisabled, Payments payments) {
        this.disResId = disResId;
        this.isDisabled = isDisabled;
        this.payments = payments;
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
