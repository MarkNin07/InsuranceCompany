package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class MedicalIncapacityChecked extends DomainEvent {

    private final ServicesId servicesId;
    private final DisResId disResId;
    private final IsDisabled isDisabled;

    public MedicalIncapacityChecked(ServicesId servicesId, DisResId disResId, IsDisabled isDisabled) {
        super("marconino.services.medicalincapacitychecked");
        this.servicesId = servicesId;
        this.disResId = disResId;
        this.isDisabled = isDisabled;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisResId getDisResId() {
        return disResId;
    }

    public IsDisabled getIsDisabled() {
        return isDisabled;
    }
}
