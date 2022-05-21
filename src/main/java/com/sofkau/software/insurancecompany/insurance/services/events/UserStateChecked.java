package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class UserStateChecked extends DomainEvent {

    private final ServicesId servicesId;
    private final ReservesId reservesId;
    private final IsAffiliated isAffiliated;

    public UserStateChecked(ServicesId servicesId, ReservesId reservesId, IsAffiliated isAffiliated) {
        super("marconino.services.userstatechecked");
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.isAffiliated = isAffiliated;
    }

    public ServicesId getServicesId() {
        return servicesId;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }

    public IsAffiliated getIsAffiliated() {
        return isAffiliated;
    }
}
