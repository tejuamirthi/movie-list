package com.assignment.movielist.Services;

import com.assignment.movielist.Entities.Actor;
import com.assignment.movielist.Entities.Movie;
import com.assignment.movielist.Exceptions.ActorNotFound;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Repositories.ActorRepository;
import com.assignment.movielist.Services.actor.ActorService;
import com.assignment.movielist.Services.actor.ActorServiceImplementation;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ActorServiceTests {

    @Mock
    private ActorRepository actorRepository;

    @InjectMocks
    private ActorService actorService = new ActorServiceImplementation();

    @Before
    public void init() {
        initMocks(this);
    }

    @Test
    public void testGetActorMethod() throws ActorNotFound {
        String testActorName = "AA MB";
        setUpStubForActorRepositoryGetByName(testActorName);
        ActorModel actor = actorService.getActor(testActorName);
        verify(actorRepository).findById(testActorName);
        assertEquals("Name Should be equal to "+testActorName, testActorName, actor.getName());
    }

    @Test(expected = ActorNotFound.class)
    public void testGetActorNotFound() throws ActorNotFound{
        ActorModel actor = actorService.getActor("Test Actor");
    }

    @Test
    public void testDeleteActor() throws ActorNotFound {
        String actorName = "Test Actor";
        Actor actor = new Actor();
        actor.setName(actorName);
        when(actorRepository.findById(actorName)).thenReturn(Optional.of(actor));
        ActorModel actorModel = new ActorModel();
        actorModel.setName(actorName);
        actorService.deleteActor(actorModel);
        verify(actorRepository, times(1)).deleteById(actorName);
    }

    @Test
    public void testCreateActor() {
        String actorName = "Test Actor";
        Actor actor = new Actor();
        actor.setName(actorName);
        when(actorRepository.save(isA(Actor.class))).thenReturn(actor);
        ActorModel actorModel = new ActorModel();
        actorModel.setName(actorName);
        ActorModel resActorModel = actorService.createActor(actorModel);
        assertEquals(actorModel, resActorModel);
    }

    private void setUpStubForActorRepositoryGetByName(String testName) {
        Optional<Actor> actor = Optional.of(new Actor());
        actor.get().setName(testName);
        when(actorRepository.findById(testName)).thenReturn(actor);
    }

}
