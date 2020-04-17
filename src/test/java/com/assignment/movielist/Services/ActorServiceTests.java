package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Actor;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Repositories.ActorRepository;
import com.assignment.movielist.Services.actor.ActorService;
import com.assignment.movielist.Services.actor.ActorServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ActorServiceTests {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorServiceImplementation actorService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetActorMethod() {
        String testActorName = "AA MB";
        setUpStubForActorRepositoryGetByName(testActorName);
        ActorModel actor = actorService.getActor(testActorName);
        verify(actorRepository).findById(testActorName);
        assertEquals("Name Should be equal to AA MB", testActorName, actor.getName());
    }

    private void setUpStubForActorRepositoryGetByName(String testName) {
        Optional<Actor> actor = Optional.of(new Actor());
        actor.get().setName(testName);
        when(actorRepository.findById(testName)).thenReturn(actor);
    }

}
