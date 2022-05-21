package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;

public class MedicalIncapacityAdded extends DomainEvent {

    private final DisResId disResId;
    private final IsDisabled isDisabled;

    public MedicalIncapacityAdded(DisResId disResId, IsDisabled isDisabled) {
        super("marconino.services.medicalincapacityadded");
        this.disResId = disResId;
        this.isDisabled = isDisabled;
    }

    public DisResId getDisResId() {
        return disResId;
    }

    public IsDisabled getIsDisabled() {
        return isDisabled;
    }
}
