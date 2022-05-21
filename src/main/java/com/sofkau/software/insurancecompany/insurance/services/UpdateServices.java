package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;

import java.util.HashSet;

public class UpdateServices extends EventChange {


    public UpdateServices(Services services) {
        apply((ServiceCreated event) -> {
            services.type = event.getType();
            services.preventionLeader = new HashSet<>();
            services.reserves = new HashSet<>();
            services.disabilityReserve = new HashSet<>();
        });
    }
}
