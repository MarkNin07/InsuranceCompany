package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class MedicalEvaluationChecked extends DomainEvent {

    private final ReservesId reservesId;
    private final MedicalEvaluation medicalEvaluation;

    public MedicalEvaluationChecked(ReservesId reservesId, MedicalEvaluation medicalEvaluation) {
        super("marconino.services.medicalevaluationchecked");
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

