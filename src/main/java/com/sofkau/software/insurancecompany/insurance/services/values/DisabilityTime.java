package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DisabilityTime implements ValueObject<Integer> {

    private final String value;

    public DisabilityTime(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Disability time is empty");
        }
    }

    @Override
    public Integer value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DisabilityTime that = (DisabilityTime) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
