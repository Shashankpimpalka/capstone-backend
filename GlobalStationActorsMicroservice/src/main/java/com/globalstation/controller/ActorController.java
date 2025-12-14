package com.globalstation.controller;


import com.globalstation.entity.ActorModel;
import com.globalstation.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v0")
@CrossOrigin("http://localhost:4200")
public class ActorController {
    @Autowired
    ActorService actorService;

    @GetMapping("/actor")
    public ResponseEntity<List<ActorModel>> getActor() {
       ;
        return ResponseEntity.ok(actorService.getAllActor());
    }

    @GetMapping(value = "/actor/{id}")
    public ResponseEntity<ActorModel> getActorById(@PathVariable int id) {

        return ResponseEntity.ok(actorService.getActorById(id));
    }

    @PostMapping("/actor")
    public ResponseEntity<ActorModel> createActor(@RequestBody ActorModel actorModel) {

        return new ResponseEntity<>(actorService.saveActor(actorModel), HttpStatus.CREATED);
    }

    @PutMapping("/actor")
    public ResponseEntity<ActorModel>  updateActor(@RequestBody ActorModel actorModel) {

        return ResponseEntity.ok(actorService.updateActor(actorModel));
    }

    @DeleteMapping(value = "/actor/{id}")
    public ResponseEntity<ActorModel> deleteActor(@PathVariable int id) {

        return ResponseEntity.ok(actorService.deleteActor(id));
    }


}

