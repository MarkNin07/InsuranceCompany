package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MedicalEvaluation implements ValueObject<String> {


    private final String value;

    public MedicalEvaluation(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("User might not be affiliated");
        }
    }

    @Override
    public String value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalEvaluation that = (MedicalEvaluation) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
