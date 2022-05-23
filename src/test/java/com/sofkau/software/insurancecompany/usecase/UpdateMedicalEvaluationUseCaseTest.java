package com.sofkau.software.insurancecompany.usecase;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import com.sofkau.software.insurancecompany.insurance.services.commands.UpdateMedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.events.MedicalEvaluationUpdated;
import com.sofkau.software.insurancecompany.insurance.services.events.ServiceCreated;
import com.sofkau.software.insurancecompany.insurance.services.usecase.UpdateMedicalEvaluationUseCase;
import com.sofkau.software.insurancecompany.insurance.services.values.MedicalEvaluation;
import com.sofkau.software.insurancecompany.insurance.services.values.ReservesId;
import com.sofkau.software.insurancecompany.insurance.services.values.ServicesId;
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
public class UpdateMedicalEvaluationUseCaseTest {

    @Mock
    private DomainEventRepository repo;
    @InjectMocks
    private UpdateMedicalEvaluationUseCase useCase;
    @Test
    void updateMedEvaTest(){

        var command = new UpdateMedicalEvaluation(ServicesId.of("210"), ReservesId.of("220"), new MedicalEvaluation("cold"));
        var eventAggCreated = new ServiceCreated(new Type("510"));
        var eventEntCreated = new MedicalEvaluationUpdated(ServicesId.of("199"), new ReservesId(), new MedicalEvaluation("healthy"));
        eventAggCreated.setAggregateRootId("510");
        eventEntCreated.setAggregateRootId("199");
        when(repo.getEventsBy("510")).thenReturn(List.of(eventAggCreated, eventEntCreated));

        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor("510")
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(() -> new IllegalArgumentException("update medical evaluation failed"))
                .getDomainEvents();

        var event = (MedicalEvaluationUpdated)  events.get(0);
        Assertions.assertEquals(command.servicesId().value(), event.servicesId().value());
        Assertions.assertEquals(command.reservesId().value(), event.reservesId().value());
        Assertions.assertEquals(command.medicalEvaluation().value(), event.medicalEvaluation().value());

    }


}
