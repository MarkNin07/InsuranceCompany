package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class MedicalEvaluationAdded extends DomainEvent {

    private final MedicalEvaluation medicalEvaluation;
    private final ReservesId reservesId;

    public MedicalEvaluationAdded(ReservesId reservesId, MedicalEvaluation medicalEvaluation) {
        super("marconino.services.medicalevaluationadded");
        this.reservesId = reservesId;
        this.medicalEvaluation = medicalEvaluation;
    }

    public MedicalEvaluation getMedicalEvaluation() {
        return medicalEvaluation;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }
}
