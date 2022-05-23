package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.events.*;
import com.sofkau.software.insurancecompany.insurance.services.values.*;
import com.sofkau.software.insurancecompany.insurance.shared.Name;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Services extends AggregateEvent<ServicesId> {

    protected Type type; //VO
    protected Set<PreventionLeader> preventionLeader;
    protected Set<Reserves> reserves;
    protected Set<DisabilityReserve> disabilityReserve;

//This constructor sends changes to the eventLog to create our Service (ServiceCreated)
    public Services(ServicesId servicesId, Type type) {
        super(servicesId);
        appendChange(new ServiceCreated(type)).apply();
    }

    private Services(ServicesId servicesId){
        super(servicesId);
        subscribe(new UpdateServices(this));
    }

//Use this constructor is useful to keep our Services up to date. it calls our second constructor
    public static Services from(ServicesId servicesId, List<DomainEvent> events){
        Services services = new Services(servicesId);
        events.forEach((event) -> services.applyEvent(event));
        return services;
        //it returns the object that was rebuilt (updated)
    }

    public void addReserves(ReservesId reservesId, IsAffiliated isAffiliated, MedicalEvaluation medicalEvaluation, DisabilityTime disabilityTime){
        Objects.requireNonNull(reservesId);
        Objects.requireNonNull(isAffiliated);
        Objects.requireNonNull(medicalEvaluation);
        Objects.requireNonNull(disabilityTime);
        appendChange(new ReservesAdded(reservesId, isAffiliated, medicalEvaluation, disabilityTime));
    }

    public void updateDisabilityTime(ServicesId servicesId, ReservesId reservesId, DisabilityTime disabilityTime){
        Objects.requireNonNull(servicesId);
        Objects.requireNonNull(reservesId);
        Objects.requireNonNull(disabilityTime);
        appendChange(new DisabilityTimeUpdated(servicesId, reservesId, disabilityTime));
    }

    public void updateMedicalEvaluation(ServicesId servicesId, ReservesId reservesId, MedicalEvaluation medicalEvaluation){
        Objects.requireNonNull(servicesId);
        Objects.requireNonNull(reservesId);
        Objects.requireNonNull(medicalEvaluation);
        appendChange(new MedicalEvaluationUpdated(servicesId, reservesId, medicalEvaluation));
    }

    public void addDisabilityReserve(DisResId disResId, IsDisabled isDisabled, Payments payments){
        Objects.requireNonNull(disResId);
        Objects.requireNonNull(isDisabled);
        Objects.requireNonNull(payments);
        appendChange(new DisabilityReserveAdded(disResId, isDisabled, payments));
    }


    public void checkUserState(ServicesId servicesId, ReservesId reservesId, IsAffiliated isAffiliated){
        Objects.requireNonNull(servicesId);
        Objects.requireNonNull(reservesId);
        Objects.requireNonNull(isAffiliated);
        appendChange(new UserStateChecked(servicesId, reservesId, isAffiliated));
    }

    public void sendPayment(ServicesId servicesId, DisResId disResId, Payments payment){
        Objects.requireNonNull(servicesId);
        Objects.requireNonNull(disResId);
        Objects.requireNonNull(payment);
        appendChange(new PaymentSent(servicesId, disResId, payment));
    }

    public void addPreventionLeader(ServicesId servicesId, LeaderId leaderId, Name leaderName){
        Objects.requireNonNull(servicesId);
        Objects.requireNonNull(leaderId);
        Objects.requireNonNull(leaderName);
        appendChange(new PreventionLeaderAdded(servicesId, leaderId, leaderName)).apply();
    }

    public void updatePreventionLeader(ServicesId servicesId, LeaderId leaderId, Name leaderName){
        Objects.requireNonNull(servicesId);
        Objects.requireNonNull(leaderId);
        Objects.requireNonNull(leaderName);
        appendChange(new PreventionLeaderUpdated(servicesId, leaderId, leaderName)).apply();
    }


    public Optional<DisabilityReserve> findDisabilityReserveById(DisResId disResId){
        return disabilityReserve().stream().filter((disResv) -> disResv.identity().equals(disResId)).findFirst();
    }


    //getters
    public Type type() {
        return type;
    }

    public Set<PreventionLeader> preventionLeader() {
        return preventionLeader;
    }

    public Set<Reserves> reserves() {
        return reserves;
    }

    public Set<DisabilityReserve> disabilityReserve() {
        return disabilityReserve;
    }


}


