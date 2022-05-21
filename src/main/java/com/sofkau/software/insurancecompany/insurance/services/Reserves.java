package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkau.software.insurancecompany.insurance.services.values.DisabilityTime;
import com.sofkau.software.insurancecompany.insurance.services.values.IsAffiliated;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;

import java.util.Objects;

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

    public void checkUserState(IsAffiliated isAffiliated){
        this.isAffiliated = Objects.requireNonNull(isAffiliated);
    }

    public void checkMedicalEvaluation(MedicalEvaluation medicalEvaluation){
        this.medicalEvaluation = Objects.requireNonNull(medicalEvaluation);
    }

    public void updateMedicalEvaluation(MedicalEvaluation medicalEvaluation){
        this.medicalEvaluation = Objects.requireNonNull(medicalEvaluation);
    }

    public void updateDisabilityTime(DisabilityTime disabilityTime){
        this.disabilityTime = Objects.requireNonNull(disabilityTime);
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
