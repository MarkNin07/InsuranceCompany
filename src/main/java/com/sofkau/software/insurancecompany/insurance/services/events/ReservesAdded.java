package com.sofkau.software.insurancecompany.insurance.services.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class ReservesAdded extends DomainEvent {
    private final ReservesId reservesId;
    private final IsAffiliated isAffiliated;
    private final MedicalEvaluation medicalEvaluation;
    private final DisabilityTime disabilityTime;

    public ReservesAdded(ReservesId reservesId, IsAffiliated isAffiliated, MedicalEvaluation medicalEvaluation, DisabilityTime disabilityTime) {
        super("marconino.services.reservesadded");
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
