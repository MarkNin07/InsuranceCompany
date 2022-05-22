package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.software.insurancecompany.insurance.services.Services;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;

import java.util.HashSet;

public class UpdateOperations extends EventChange {

    public UpdateOperations(Operations operations) {
        apply((ServiceCreated event) -> {
            operations.type = event.getType();
            operations.operationManager = new HashSet<>();
            operations.memberships = new HashSet<>();
            operations.portfolio = new HashSet<>();
        });
    }
}
