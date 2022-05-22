package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.*;

public class AddReserves extends Command {

    private final ServicesId servicesId;
    private final ReservesId reservesId;
    private final IsAffiliated isAffiliated;
    private final MedicalEvaluation medicalEvaluation;
    private final DisabilityTime disabilityTime;

    public AddReserves(ServicesId servicesId, ReservesId reservesId, IsAffiliated isAffiliated, MedicalEvaluation medicalEvaluation, DisabilityTime disabilityTime) {
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.isAffiliated = isAffiliated;
        this.medicalEvaluation = medicalEvaluation;
        this.disabilityTime = disabilityTime;
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

    public MedicalEvaluation medicalEvaluation() {
        return medicalEvaluation;
    }

    public DisabilityTime disabilityTime() {
        return disabilityTime;
    }
}
