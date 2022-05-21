package com.sofkau.software.insurancecompany.insurance.services;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
import com.sofkau.software.insurancecompany.insurance.shared.Type;

import java.util.List;
import java.util.Set;

public class Services extends AggregateEvent<ServicesId> {

    protected Type type;
    protected Set<PreventionLeader> preventionLeader;
    protected Set<Reserves> reserves;
    protected Set<DisabilityReserve> disabilityReserve;

//This constructor sends changes to the eventLog to create our Service (ServiceCreated)
    public Services(ServicesId entityId, Type type) {
        super(entityId);
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


