package com.globalstation.service;

import com.globalstation.entity.AdminModel;
import com.globalstation.exception.AdminNotFound;
import com.globalstation.exception.EmailAlreadyInUseException;
import com.globalstation.exception.GlobalExceptionHandler;
import com.globalstation.exception.PhoneALreadyInUseException;
import com.globalstation.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public List<AdminModel> getAllAdmin(){
        return adminRepository.findAll();
    }

    public AdminModel getAdminById(int id) throws AdminNotFound{
        AdminModel adminModel = adminRepository.findById(id).orElseThrow(
                ()-> new AdminNotFound("Admin not found for Given Id "+ id));

        return adminModel;
    }

    public AdminModel saveAdmin(AdminModel adminModel){
        try {
            return adminRepository.save(adminModel);
        }catch (Exception e) {
            throw new EmailAlreadyInUseException("Email already in use"+adminModel.getEmail());
        }

    }

    public AdminModel updateAdmin(AdminModel adminModel){
        AdminModel adminModel1 = adminRepository.findById(adminModel.getAdminId()).orElseThrow(
                ()-> new AdminNotFound("Admin not found for Given id " + adminModel.getAdminId()));

        adminModel1.setFirstName(adminModel.getFirstName());
        adminModel1.setLastName(adminModel.getLastName());
        adminModel1.setEmail(adminModel.getEmail());


        adminModel1.setPhone(adminModel.getPhone());
        adminModel1.setEmail(adminModel.getEmail());
        adminModel1.setPassword(adminModel.getPassword());
        try {
            return   adminRepository.save(adminModel1);
        }catch (EmailAlreadyInUseException e){
            throw new EmailAlreadyInUseException("Email already in use"+adminModel.getEmail());
        }

    }

    public AdminModel deleteAdmin(int id){

        AdminModel adminModel = adminRepository.findById(id).orElseThrow(
                ()-> new AdminNotFound("Admin not found for Given Id "+ id));

        adminRepository.deleteById(adminModel.getAdminId());

        return adminModel;

    }

    public AdminModel authenticateAdmin(String email, String password) throws AdminNotFound {
        AdminModel adminModel = adminRepository.findByEmailAndPassword(email,password);
        System.out.println("authenticateAdmin Service "+adminModel);
        if(adminModel == null)
            throw new AdminNotFound("You are not registered Please Signup");
        else
            return adminModel;
    }

    public Boolean emailInUse(String email) throws EmailAlreadyInUseException {

        AdminModel emailInUse= adminRepository.findByEmail(email);
        System.out.println("Service emailInUse method emailId "+emailInUse);

        if(emailInUse != null)
            throw new EmailAlreadyInUseException("Email already in use");
        else
            return false;

    }

    public Boolean phoneInUse(String phone) throws PhoneALreadyInUseException {
        AdminModel existingPhone = adminRepository.findByPhone(phone);
        if(existingPhone != null)
            throw new PhoneALreadyInUseException("Phone number in use.");
        else
            return false;
    }

}
