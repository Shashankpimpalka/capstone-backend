package com.globalstation.repository;

import com.globalstation.entity.AdminModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<AdminModel, Integer> {
    AdminModel findByEmail(String email);
    AdminModel findByPhone(String phone);
    AdminModel  findByEmailAndPassword(String email, String password);

}
