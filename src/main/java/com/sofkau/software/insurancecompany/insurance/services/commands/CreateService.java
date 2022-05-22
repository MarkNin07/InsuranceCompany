package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

public class CreateService extends Command {

    private final ServicesId servicesId;
    private final Type type;

    public CreateService(ServicesId servicesId, Type type ) {
        this.servicesId = servicesId;
        this.type = type;
    }

    public Type type() {
        return type;
    }

    public ServicesId servicesId() {
        return servicesId;
    }


}
