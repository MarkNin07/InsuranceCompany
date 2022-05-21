package com.sofkau.software.insurancecompany.insurance.services.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class IsAffiliated implements ValueObject<Boolean> {

    private final String value;

    public IsAffiliated(String value) {
        this.value = Objects.requireNonNull(value);
        if (this.value.isBlank()){
            throw new IllegalArgumentException("User might not be affiliated");
        }
    }

    @Override
    public Boolean value() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IsAffiliated that = (IsAffiliated) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
