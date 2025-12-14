package com.globalstation.repository;



import com.globalstation.entity.ActorModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActorRepository extends JpaRepository<ActorModel,Integer> {
  //  Optional<ActorModel> findByNameAndAgeAndGender(String name, int age, char g);
}
