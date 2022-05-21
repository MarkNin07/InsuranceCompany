package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class AddMedicalIncapacity extends Command {

    private final ServicesId servicesId;
    private final DisResId disResId;
    private final IsDisabled isDisabled;

    public AddMedicalIncapacity(ServicesId servicesId, DisResId disResId, IsDisabled isDisabled) {
        this.servicesId = servicesId;
        this.disResId = disResId;
        this.isDisabled = isDisabled;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisResId disResId() {
        return disResId;
    }

    public IsDisabled isDisabled() {
        return isDisabled;
    }
}
