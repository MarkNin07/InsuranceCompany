package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class DisabilityTimeUpdated extends DomainEvent {

    private final DisabilityTime disabilityTime;
    private final ReservesId reservesId;

    public DisabilityTimeUpdated(ReservesId reservesId, DisabilityTime disabilityTime) {
        super("marconino.services.disabilitytimeupdated");
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
