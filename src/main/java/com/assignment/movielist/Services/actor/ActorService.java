package com.assignment.movielist.Services.actor;

import com.assignment.movielist.Entities.Actor;
import com.assignment.movielist.Exceptions.ActorNotFound;
import com.assignment.movielist.Models.ActorModel;

public interface ActorService {
    ActorModel getActor(String name) throws ActorNotFound;
    ActorModel createActor(ActorModel actorModel);
    ActorModel deleteActor(ActorModel actorModel) throws ActorNotFound;
}
