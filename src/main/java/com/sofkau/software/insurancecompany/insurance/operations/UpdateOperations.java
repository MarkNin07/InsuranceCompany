package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.EventChange;
import com.sofkau.software.insurancecompany.insurance.operations.events.*;

import java.util.HashSet;

public class UpdateOperations extends EventChange {

    public UpdateOperations(Operations operations) {
        apply((OperationCreated event) -> {
            operations.type = event.getType();
            operations.operationManager = new HashSet<>();
            operations.memberships = new HashSet<>();
            operations.portfolio = new HashSet<>();
        });

        apply((MembershipAdded event) -> {
            operations.memberships.add(new Membership(event.membershipId(), event.phoneNumber(), event.email()));
        });

        apply((MembershipEmailUpdated event) -> {
            var membership = new Membership(event.membershipId());
            membership.updateMembershipEmail(event.email());
        });

        apply((OperationLeaderAdded event) -> {
            operations.operationManager.add(new OperationManager(event.managerId(), event.managerName()));
        });

        apply((OperationLeaderUpdated event) -> {
            var leaderUpdated = new OperationManager(event.managerId());
            leaderUpdated.updateOperationLeader(event.managerName());
        });

        apply((PhoneNumberUpdated event) -> {
            var phoneNum = new Membership(event.membershipId());
            phoneNum.updatePhoneNumber(event.phoneNumber());
        });

        apply((PortfolioAdded event) -> {
            operations.portfolio.add(new Portfolio(event.portfolioId(), event.bankAccount(), event.email()));
        });

        apply((PortfolioEmailUpdated event) -> {
            var portfEmail = new Portfolio(event.portfolioId());
            portfEmail.updatePortfolioEmail(event.email());
        });
    }
}
