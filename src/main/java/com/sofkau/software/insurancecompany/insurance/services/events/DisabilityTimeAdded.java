package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class DisabilityTimeAdded extends DomainEvent {

    //instantiate my DisabilityTime value
    private final DisabilityTime disabilityTime;
    //To be able to take the value above, I need the entity ID
    private final ReservesId reservesId;

    public DisabilityTimeAdded( ReservesId reservesId, DisabilityTime disabilityTime) {
        super("marconino.services.disabilitytimeadded");
        this.reservesId = reservesId;
        this.disabilityTime = disabilityTime;

    }

    public DisabilityTime getDisabilityTime() {
        return disabilityTime;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }
}
