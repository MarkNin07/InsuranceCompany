package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class AddDisabilityTime extends Command {

    private final ReservesId reservesId;
    private final ServicesId servicesId;
    private final DisabilityTime disabilityTime;

    public AddDisabilityTime(ReservesId reservesId, ServicesId servicesId, DisabilityTime disabilityTime){
        this.reservesId = reservesId;
        this.servicesId = servicesId;
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
