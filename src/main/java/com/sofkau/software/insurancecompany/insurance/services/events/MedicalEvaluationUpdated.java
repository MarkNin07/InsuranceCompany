package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class MedicalEvaluationUpdated extends DomainEvent {


    private final ServicesId servicesId;
    private final ReservesId reservesId;
    private final MedicalEvaluation medicalEvaluation;

    public MedicalEvaluationUpdated(ServicesId servicesId, ReservesId reservesId, MedicalEvaluation medicalEvaluation) {
        super("marconino.services.medicalevaluationupdated");
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
