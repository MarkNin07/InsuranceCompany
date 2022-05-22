package com.sofkau.software.insurancecompany.insurance.operations.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class PhoneNumber implements ValueObject {

    private final String value;

    public PhoneNumber(String value) {
        this.value =  Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("Bank account time is empty");
        }
    }

    @Override
    public Object value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
