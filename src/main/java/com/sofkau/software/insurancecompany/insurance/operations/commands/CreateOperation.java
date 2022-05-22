package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

public class CreateOperation extends Command {

    private final OperationsId operationsId;
    private final Type type;

    public CreateOperation(OperationsId operationsId, Type type) {
        this.operationsId = operationsId;
        this.type = type;
    }

    public OperationsId operationsId() {
        return operationsId;
    }

    public Type type() {
        return type;
    }
}
