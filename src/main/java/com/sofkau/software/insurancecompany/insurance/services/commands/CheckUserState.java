package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class CheckUserState extends Command {

    private final ServicesId servicesId;
    private final ReservesId reservesId;
    private final IsAffiliated isAffiliated;

    public CheckUserState(ServicesId servicesId, ReservesId reservesId, IsAffiliated isAffiliated) {
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.isAffiliated = isAffiliated;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public ReservesId reservesId() {
        return reservesId;
    }

    public IsAffiliated isAffiliated() {
        return isAffiliated;
    }
}
