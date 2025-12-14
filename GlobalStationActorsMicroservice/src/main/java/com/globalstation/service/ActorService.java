package com.globalstation.service;



import com.globalstation.entity.ActorModel;
import com.globalstation.exception.ActorNotFound;
import com.globalstation.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    ActorRepository actorRepository;

    public List<ActorModel> getAllActor() {
        return actorRepository.findAll();
    }

    public ActorModel saveActor(ActorModel actorModel1) {

        return actorRepository.save(actorModel1);
    }


    public ActorModel getActorById(int id) {
        return actorRepository.findById(id).orElseThrow(
                () -> new ActorNotFound("Actor not found for given Id " + id));
    }

    public ActorModel updateActor(ActorModel actorModel) {
        ActorModel actorModel1 = actorRepository.findById(actorModel.getActorId()).orElseThrow(() -> new ActorNotFound("Actor not found for given Id " + actorModel.getActorId()));
        actorModel1.setFirstName(actorModel.getFirstName());
        actorModel1.setLastName(actorModel.getLastName());
        actorModel1.setAge(actorModel.getAge());
        actorModel1.setGender(actorModel.getGender());
        return actorRepository.save(actorModel1);
    }

    public ActorModel deleteActor(int id) {
        ActorModel actorModel = actorRepository.findById(id).orElseThrow(
                () -> new ActorNotFound("Actor not found for given Id " + id));
        actorRepository.deleteById(id);
        return actorModel;
    }


}

