package com.sofkau.software.insurancecompany.insurance.operations;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.operations.events.*;
import com.sofkau.software.insurancecompany.insurance.operations.values.*;
import com.sofkau.software.insurancecompany.insurance.services.events.PreventionLeaderUpdated;
import com.sofkau.software.insurancecompany.insurance.services.events.ReservesAdded;
import com.sofkau.software.insurancecompany.insurance.shared.Name;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Operations extends AggregateEvent<OperationsId> {


    protected Type type;
    protected Set<OperationManager> operationManager;
    protected Set<Portfolio> portfolio;
    protected Set<Membership> memberships;

    public Operations(OperationsId operationsId, Type type) {
        super(operationsId);
        appendChange(new OperationCreated(type)).apply();
    }

    public Operations(OperationsId operationsId) {
        super(operationsId);
        subscribe(new UpdateOperations(this));
    }

    public static Operations from(OperationsId operationsId, List<DomainEvent> events){
        Operations operations = new Operations(operationsId);
        events.forEach((event) -> operations.applyEvent(event));
        return operations;
    }


    public void addOperationLeader(OperationsId operationsId, ManagerId managerId, Name managerName){
        Objects.requireNonNull(managerId);
        Objects.requireNonNull(managerName);
        appendChange(new OperationLeaderAdded(operationsId, managerId, managerName));
    }

    public void updateOperationLeader(OperationsId operationsId, ManagerId managerId, Name managerName){
        Objects.requireNonNull(operationsId);
        Objects.requireNonNull(managerId);
        Objects.requireNonNull(managerName);
        appendChange(new OperationLeaderUpdated(operationsId, managerId, managerName)).apply();
    }

    public void addPortfolio(OperationsId operationsId, PortfolioId portfolioId, BankAccount bankAccount, Email email){
        Objects.requireNonNull(operationsId);
        Objects.requireNonNull(portfolioId);
        Objects.requireNonNull(bankAccount);
        Objects.requireNonNull(email);
        appendChange(new PortfolioAdded(operationsId, portfolioId, bankAccount, email));
    }

    public void updatePortfolioEmail(OperationsId operationsId, PortfolioId portfolioId, Email email){
        Objects.requireNonNull(operationsId);
        Objects.requireNonNull(portfolioId);
        Objects.requireNonNull(email);
        appendChange(new PortfolioEmailUpdated(operationsId, portfolioId, email));
    }

    public void addMembership(OperationsId operationsId, MembershipId membershipId, PhoneNumber phoneNumber, Email email){
        Objects.requireNonNull(operationsId);
        Objects.requireNonNull(membershipId);
        Objects.requireNonNull(phoneNumber);
        Objects.requireNonNull(email);
        appendChange(new MembershipAdded(operationsId, membershipId, phoneNumber, email));
    }

    public void updatePhoneNumber(OperationsId operationsId, MembershipId membershipId, PhoneNumber phoneNumber){
        Objects.requireNonNull(operationsId);
        Objects.requireNonNull(membershipId);
        Objects.requireNonNull(phoneNumber);
        appendChange(new PhoneNumberUpdated(operationsId, membershipId, phoneNumber));
    }

    public void updateMembershipEmail(OperationsId operationsId, MembershipId membershipId, Email email){
        Objects.requireNonNull(operationsId);
        Objects.requireNonNull(membershipId);
        Objects.requireNonNull(email);
        appendChange(new MembershipEmailUpdated(operationsId, membershipId, email));
    }



    public Type type() {
        return type;
    }

    public Set<OperationManager> getOperationManager() {
        return operationManager;
    }

    public Set<Portfolio> getPortfolio() {
        return portfolio;
    }

    public Set<Membership> getMemberships() {
        return memberships;
    }
}
