package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class DisabilityTimeUpdated extends DomainEvent {

    private final ServicesId servicesId;
    private final DisabilityTime disabilityTime;
    private final ReservesId reservesId;

    public DisabilityTimeUpdated(ServicesId servicesId, ReservesId reservesId, DisabilityTime disabilityTime) {
        super("marconino.services.disabilitytimeupdated");
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
