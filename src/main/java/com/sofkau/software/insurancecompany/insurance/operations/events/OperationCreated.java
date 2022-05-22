package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

public class OperationCreated extends DomainEvent {

    private final Type type;

    public OperationCreated(Type type) {
        super("marconino.operations.operationcreated");
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
