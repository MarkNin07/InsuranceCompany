package com.sofkau.software.insurancecompany.insurance.operations.commands;

import co.com.sofka.domain.generic.Command;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;

public class UpdateMembershipEmail extends Command {

    private final OperationsId operationsId;
    private final MembershipId membershipId;
    private final Email email;

    public UpdateMembershipEmail(OperationsId operationsId, MembershipId membershipId, Email email) {
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
