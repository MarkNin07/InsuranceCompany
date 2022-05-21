package com.sofkau.software.insurancecompany.insurance.services.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class CheckMedicalEvaluation extends Command {


    private final ServicesId servicesId;
    private final ReservesId reservesId;
    private final MedicalEvaluation medicalEvaluation;

    public CheckMedicalEvaluation(ServicesId servicesId, ReservesId reservesId, MedicalEvaluation medicalEvaluation) {
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.medicalEvaluation = medicalEvaluation;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public ReservesId reservesId() {
        return reservesId;
    }

    public MedicalEvaluation medicalEvaluation() {
        return medicalEvaluation;
    }
}
