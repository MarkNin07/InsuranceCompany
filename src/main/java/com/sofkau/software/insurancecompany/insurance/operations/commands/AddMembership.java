package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PhoneNumber;

public class AddMembership extends Command {

    private final OperationsId operationsId;
    private final MembershipId membershipId;
    private final PhoneNumber phoneNumber;
    private final Email email;

    public AddMembership(OperationsId operationsId, MembershipId membershipId, PhoneNumber phoneNumber, Email email) {
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
