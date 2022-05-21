package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

public class Reserves extends Entity<ReservesId> {


    private IsAffiliated isAffiliated;
    private MedicalEvaluation medicalEvaluation;
    private DisabilityTime disabilityTime;

    public Reserves(ReservesId reservesId, IsAffiliated isAffiliated, MedicalEvaluation medicalEvaluation, DisabilityTime disabilityTime) {
        super(reservesId);
        this.isAffiliated = isAffiliated;
        this.medicalEvaluation = medicalEvaluation;
        this.disabilityTime = disabilityTime;
    }

    public IsAffiliated getIsAffiliated() {
        return isAffiliated;
    }

    public MedicalEvaluation getMedicalEvaluation() {
        return medicalEvaluation;
    }

    public DisabilityTime getDisabilityTime() {
        return disabilityTime;
    }
}
