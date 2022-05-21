package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class CreateService extends Command {

    private final ServicesId servicesId;

    public CreateService(ServicesId servicesId) {
        this.servicesId = servicesId;
    }

    public ServicesId servicesId() {
        return servicesId;
    }


}
