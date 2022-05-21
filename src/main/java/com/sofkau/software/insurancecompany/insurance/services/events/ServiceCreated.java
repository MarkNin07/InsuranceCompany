package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

public class ServiceCreated extends DomainEvent {

    private final Type type;

    public ServiceCreated(Type type) {
        super("marconino.services.servicecreated");
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
