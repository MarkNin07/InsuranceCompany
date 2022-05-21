package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class UpdateDisabilityTime extends Command {

    private final ServicesId servicesId;
    private final ReservesId reservesId;
    private final DisabilityTime disabilityTime;

    public UpdateDisabilityTime(ServicesId servicesId, ReservesId reservesId, DisabilityTime disabilityTime) {
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.disabilityTime = disabilityTime;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public ReservesId reservesId() {
        return reservesId;
    }

    public DisabilityTime disabilityTime() {
        return disabilityTime;
    }
}
