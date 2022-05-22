package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PhoneNumber;

public class MembershipAdded extends DomainEvent {


    private final OperationsId operationsId;
    private final MembershipId membershipId;
    private final PhoneNumber phoneNumber;
    private final Email email;

    public MembershipAdded(OperationsId operationsId, MembershipId membershipId, PhoneNumber phoneNumber, Email email) {
        super("marconino.operations.membershipadded");
        this.operationsId = operationsId;
        this.membershipId = membershipId;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public Email email() {
        return email;
    }
}
