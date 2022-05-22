package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;

public class DisabilityReserveAdded extends DomainEvent {

    private final DisResId disResId;
    private final IsDisabled isDisabled;
    private final Payments payments;

    public DisabilityReserveAdded(DisResId disResId, IsDisabled isDisabled, Payments payments) {
        super("marconino.services.disabilityreserveadded");
        this.disResId = disResId;
        this.isDisabled = isDisabled;
        this.payments = payments;
    }

    public DisResId disResId() {
        return disResId;
    }

    public IsDisabled isDisabled() {
        return isDisabled;
    }

    public Payments payments() {
        return payments;
    }
}
