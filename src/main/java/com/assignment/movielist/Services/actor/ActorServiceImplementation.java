package com.assignment.movielist.Services.actor;


import com.assignment.movielist.Entities.Actor;
import com.assignment.movielist.Exceptions.ActorNotFound;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Repositories.ActorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ActorServiceImplementation implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public ActorModel getActor(String name) throws ActorNotFound {
        Optional<Actor> actor = actorRepository.findById(name);
        if(!actor.isPresent())
            throw new ActorNotFound("Actor Not found");
        ActorModel actorModel = new ActorModel();
        BeanUtils.copyProperties(actor.get(), actorModel);
        return actorModel;
    }

    @Transactional
    @Override
    public ActorModel createActor(ActorModel actorModel) {
        Actor actor = new Actor();
        BeanUtils.copyProperties(actorModel,actor);
        actorRepository.save(actor);
        return actorModel;
    }

    @Transactional
    @Override
    public ActorModel deleteActor(ActorModel actorModel) throws ActorNotFound {
        try {
            actorRepository.deleteById(actorModel.getName());
            return actorModel;
        } catch (Exception e) {
            e.printStackTrace();
            throw new ActorNotFound("Actor Not found");
        }
    }
}
