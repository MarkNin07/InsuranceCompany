package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Payments implements ValueObject<Long> {


    private final String value;

    public Payments(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("User might not be affiliated");
        }
    }

    @Override
    public Long value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payments payments = (Payments) o;
        return Objects.equals(value, payments.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
