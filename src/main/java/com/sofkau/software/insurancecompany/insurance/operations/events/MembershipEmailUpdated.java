package com.sofkau.software.insurancecompany.insurance.operations.events;

import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;

public class MembershipEmailUpdated extends DomainEvent {


    private final OperationsId operationsId;
    private final MembershipId membershipId;
    private final Email email;

    public MembershipEmailUpdated(OperationsId operationsId, MembershipId membershipId, Email email) {
        super("marconino.operations.membershipemailupdated");
        this.operationsId = operationsId;
        this.membershipId = membershipId;
        this.email = email;
    }

    public OperationsId operationsId() {
        return operationsId;
    }

    public MembershipId membershipId() {
        return membershipId;
    }

    public Email email() {
        return email;
    }
}
