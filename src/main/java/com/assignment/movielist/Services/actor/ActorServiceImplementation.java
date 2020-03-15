package com.assignment.movielist.Services.actor;


import com.assignment.movielist.Entities.Actor;
import com.assignment.movielist.Models.ActorModel;
import com.assignment.movielist.Repositories.ActorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ActorServiceImplementation implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public ActorModel getActor(String name) {
        Actor actor = actorRepository.findById(name).get();
        ActorModel actorModel = new ActorModel();
        BeanUtils.copyProperties(actor, actorModel);
        return actorModel;
    }

    @Transactional
    @Override
    public void createActor(ActorModel actorModel) {
        Actor actor = new Actor();
        BeanUtils.copyProperties(actorModel,actor);
        actorRepository.save(actor);
    }

    @Transactional
    @Override
    public void deleteActor(String name) {
        actorRepository.deleteById(name);
    }
}
