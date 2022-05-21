package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class DisabilityTimeAdded extends DomainEvent {

    private final ServicesId servicesId;
    //instantiate my DisabilityTime value
    private final DisabilityTime disabilityTime;
    //To be able to take the value above, I need the entity ID
    private final ReservesId reservesId;


    public DisabilityTimeAdded(ServicesId servicesId, ReservesId reservesId, DisabilityTime disabilityTime) {
        super("marconino.services.disabilitytimeadded");
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.disabilityTime = disabilityTime;

    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public DisabilityTime getDisabilityTime() {
        return disabilityTime;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }
}
