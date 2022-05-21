package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;

public class MedicalEvaluationAdded extends DomainEvent {

    private final ServicesId servicesId;
    private final MedicalEvaluation medicalEvaluation;
    private final ReservesId reservesId;

    public MedicalEvaluationAdded(ServicesId servicesId, ReservesId reservesId, MedicalEvaluation medicalEvaluation) {
        super("marconino.services.medicalevaluationadded");
        this.servicesId = servicesId;
        this.reservesId = reservesId;
        this.medicalEvaluation = medicalEvaluation;
    }

    public ServicesId servicesId() {
        return servicesId;
    }

    public MedicalEvaluation getMedicalEvaluation() {
        return medicalEvaluation;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }
}
