package com.globalstation.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor(staticName = "getInstanceOf")
@NoArgsConstructor
public class ActorDTO {

    private int actorId;

    private String firstName;
    private String lastName;
    private char gender;

    private int age;
}
