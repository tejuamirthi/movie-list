package com.assignment.movielist.Services.actor;

import com.assignment.movielist.Entities.Actor;
import com.assignment.movielist.Models.ActorModel;

public interface ActorService {
    ActorModel getActor(String name);
    void createActor(ActorModel actorModel);
    void deleteActor(ActorModel actorModel);
}
