package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class MedicalEvaluationUpdated extends DomainEvent {

    private final ReservesId reservesId;
    private final MedicalEvaluation medicalEvaluation;

    public MedicalEvaluationUpdated(ReservesId reservesId, MedicalEvaluation medicalEvaluation) {
        super("marconino.services.medicalevaluationupdated");
        this.reservesId = reservesId;
        this.medicalEvaluation = medicalEvaluation;
    }

    public ReservesId getReservesId() {
        return reservesId;
    }

    public MedicalEvaluation getMedicalEvaluation() {
        return medicalEvaluation;
    }
}
