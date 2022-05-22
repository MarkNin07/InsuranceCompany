package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.Entity;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PhoneNumber;

import java.util.Objects;

public class Membership extends Entity<MembershipId> {


    private PhoneNumber phoneNumber;
    private Email email;

    public Membership(MembershipId membershipId, PhoneNumber phoneNumber, Email email) {
        super(membershipId);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Membership(MembershipId membershipId){
        super(membershipId);
    }

    public void updatePhoneNumber(PhoneNumber phoneNumber){
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    public void updateMembershipEmail(Email email){
        this.email = Objects.requireNonNull(email);

    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public Email email() {
        return email;
    }
}
