package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PhoneNumber;

public class PhoneNumberUpdated extends DomainEvent {


    private final OperationsId operationsId;
    private final MembershipId membershipId;
    private final PhoneNumber phoneNumber;

    public PhoneNumberUpdated(OperationsId operationsId, MembershipId membershipId, PhoneNumber phoneNumber) {
        super("marconino.operations.phonenumberupdated");
        this.operationsId = operationsId;
        this.membershipId = membershipId;
        this.phoneNumber = phoneNumber;
    }

    public OperationsId operationsId() {
        return operationsId;
    }

    public MembershipId membershipId() {
        return membershipId;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }
}
