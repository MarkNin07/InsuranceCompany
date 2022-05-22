package com.sofkau.software.insurancecompany.insurance.operations.values;

import co.com.sofka.domain.generic.Identity;

public class PortfolioId extends Identity {

    public PortfolioId(String uuid) {
        super(uuid);
    }

    public PortfolioId() {
    }

    public static PortfolioId of(String id){
        return new PortfolioId(id);
    }

}
