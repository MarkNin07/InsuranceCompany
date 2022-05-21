package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class UserStateChecked extends DomainEvent {

    private final ReservesId reservesId;
    private final IsAffiliated isAffiliated;

    public UserStateChecked(ReservesId reservesId, IsAffiliated isAffiliated) {
        super("marconino.services.userstatechecked");
        this.reservesId = reservesId;
        this.isAffiliated = isAffiliated;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }

    public IsAffiliated getIsAffiliated() {
        return isAffiliated;
    }
}
