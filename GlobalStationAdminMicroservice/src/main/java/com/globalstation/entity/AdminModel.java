package com.globalstation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "admin_id")
    int adminId;

    @Column(name = "first_name", nullable = false)
    String firstName;


    @Column(name = "last_name", nullable = false)
    String lastName;


    @Column(name = "password", nullable = false)
    String password;


    @Column(name = "phone", nullable = false)
    private String phone;


    @Column(name = "email", nullable = false, unique = true)
    private String email;


}
