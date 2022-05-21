package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

public class ServiceCreated extends DomainEvent {

    private final ServicesId servicesId;
    private final Type type;

    public ServiceCreated(ServicesId servicesId, Type type) {
        super("marconino.services.servicecreated");
        this.servicesId = servicesId;
        this.type = type;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public Type getType() {
        return type;
    }
}
