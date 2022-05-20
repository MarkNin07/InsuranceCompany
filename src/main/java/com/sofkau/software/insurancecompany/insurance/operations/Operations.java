package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;

public class Operations extends AggregateEvent<OperationsId> {



    public Operations(OperationsId entityId) {
        super(entityId);
    }
}
