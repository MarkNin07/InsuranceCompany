package com.sofkau.software.insurancecompany.usecase;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.operations.commands.AddMembership;
import com.sofkau.software.insurancecompany.insurance.operations.events.MembershipAdded;
import com.sofkau.software.insurancecompany.insurance.operations.events.OperationCreated;
import com.sofkau.software.insurancecompany.insurance.operations.usecase.AddMembershipUseCase;
import com.sofkau.software.insurancecompany.insurance.operations.values.Email;
import com.sofkau.software.insurancecompany.insurance.operations.values.MembershipId;
import com.sofkau.software.insurancecompany.insurance.operations.values.OperationsId;
import com.sofkau.software.insurancecompany.insurance.operations.values.PhoneNumber;
import com.sofkau.software.insurancecompany.insurance.shared.Type;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
public class AddMembershipUseCaseTest {

    @Mock
    private DomainEventRepository repo;
    @InjectMocks
    private AddMembershipUseCase useCase;
    @Test
    void memberShipTest(){

        var command = new AddMembership(OperationsId.of("320"), new MembershipId(), new PhoneNumber("315312"), new Email("m@c"));
        var eventAggCreat = new OperationCreated(new Type("create membership"));
        eventAggCreat.setAggregateRootId("320");
        when(repo.getEventsBy("320")).thenReturn(List.of(eventAggCreat));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("320")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("Check your membership"))
                .getDomainEvents();

        var event = (MembershipAdded) events.get(0);
        Assertions.assertEquals(command.operationsId().value(), event.operationsId().value());
        Assertions.assertEquals(command.membershipId().value(), event.membershipId().value());
        Assertions.assertEquals(command.phoneNumber().value(), event.phoneNumber().value());
        Assertions.assertEquals(command.email().value(), event.email().value());

    }

}
