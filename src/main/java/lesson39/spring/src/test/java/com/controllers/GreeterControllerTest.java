package com.controllers;

import com.models.Greeter;
import com.repositories.GreeterRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class GreeterControllerTest {

    private GreeterController target;

    private GreeterRepository repository;

    private Greeter greeter;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(GreeterRepository.class);
        target = new GreeterController(repository);
        greeter = new Greeter();
        greeter.setIdentifier(UUID.randomUUID().toString());
        greeter.setGreeting("Default");
    }

    @Test
    void findOne_success() {
        // configuration
        final String id = "123";
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(greeter));

        // Call test method
        final Greeter actual = target.findOne(id);

        // Checks
        Assertions.assertEquals(greeter.getIdentifier(), actual.getIdentifier());
    }

    @Test
    void findOne_notFound() {
        // configuration
        final String id = "123";
        Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

        // Call test method
        Assertions.assertThrows(IllegalArgumentException.class, () -> target.findOne(id));

        // Checks
    }

    @Test
    void create_success() {
        // configuration

        // Call test method
        target.create(greeter);

        // Checks
        Mockito.verify(repository).save(Mockito.any());
        Mockito.verify(repository).save(greeter);
        Mockito.verify(repository).save(Mockito.argThat(
                actual -> greeter.getIdentifier().equals(actual.getIdentifier()))
        );
    }

    @Test
    void create_noGreeting() {
        // configuration
        greeter.setGreeting(null);

        // Call test method
        target.create(greeter);

        // Checks
        Mockito.verify(repository).save(Mockito.argThat(
                        actual -> "Hello".equals(actual.getGreeting()) &&
                                greeter.getIdentifier().equals(actual.getIdentifier())
                )
        );
    }
}