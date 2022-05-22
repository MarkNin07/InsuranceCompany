package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PhoneNumber;

public class UpdatePhoneNumber  extends Command {

    private final OperationsId operationsId;
    private final MembershipId membershipId;
    private final PhoneNumber phoneNumber;

    public UpdatePhoneNumber(OperationsId operationsId, MembershipId membershipId, PhoneNumber phoneNumber) {
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

