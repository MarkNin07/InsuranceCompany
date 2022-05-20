package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.AggregateEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class Services extends AggregateEvent<ServicesId> {

    
    public Services(ServicesId entityId) {
        super(entityId);
    }
}
