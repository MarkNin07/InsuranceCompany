package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.domain.generic.Identity;
import com.sofkau.software.insurancecompany.insurance.services.values.DisResId;
import com.sofkau.software.insurancecompany.insurance.services.values.IsDisabled;
import com.sofkau.software.insurancecompany.insurance.services.values.Payments;

import java.util.Objects;

public class DisabilityReserve extends Entity<DisResId> {


    private IsDisabled isDisabled;
    private Payments payment;

    public DisabilityReserve(DisResId disResId, IsDisabled isDisabled, Payments payment) {
        super(disResId);
        this.isDisabled = isDisabled;
        this.payment = payment;
    }

    public void checkMedicalIncapacity(IsDisabled isDisabled){
        this.isDisabled = Objects.requireNonNull(isDisabled);
    }

    public void sendPayment(Payments payment){
        this.payment = Objects.requireNonNull(payment);
    }

    public IsDisabled isDisabled() {
        return isDisabled;
    }

    public Payments payment() {
        return payment;
    }
}
