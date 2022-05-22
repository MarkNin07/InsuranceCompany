package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class AddReserves extends Command {
    private final ReservesId reservesId;
    private final IsAffiliated isAffiliated;
    private final MedicalEvaluation medicalEvaluation;
    private final DisabilityTime disabilityTime;

    public AddReserves(ReservesId reservesId, IsAffiliated isAffiliated, MedicalEvaluation medicalEvaluation, DisabilityTime disabilityTime) {
        this.reservesId = reservesId;
        this.isAffiliated = isAffiliated;
        this.medicalEvaluation = medicalEvaluation;
        this.disabilityTime = disabilityTime;
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
