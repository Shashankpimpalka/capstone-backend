package com.globalstation.controller;


import com.globalstation.entity.AdminModel;
import com.globalstation.entity.MovieDTO;
import com.globalstation.exception.EmailAlreadyInUseException;
import com.globalstation.exception.PhoneALreadyInUseException;
import com.globalstation.external.service.MovieService;
import com.globalstation.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
@CrossOrigin("http://localhost:4200")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    private MovieService movieService;

    @GetMapping("/admin")
    public ResponseEntity<List<AdminModel>> getAllAdmin() {
        return ResponseEntity.ok(adminService.getAllAdmin());
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<AdminModel> getAdminById(@PathVariable int id) {

        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @PostMapping("/admin")
    public ResponseEntity<AdminModel> createAdmin(@RequestBody AdminModel adminModel) {
        try {
            return new ResponseEntity<>(adminService.saveAdmin(adminModel), HttpStatus.CREATED);
        } catch (EmailAlreadyInUseException e) {
            throw new EmailAlreadyInUseException("Email " + adminModel.getEmail() + "already in use, Please provide alternate email ");
        }
    }

    @PutMapping("/admin")
    public ResponseEntity<AdminModel> updateAdmin(@RequestBody AdminModel adminModel) {
        return ResponseEntity.ok(adminService.updateAdmin(adminModel));
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<AdminModel> deleteAdmin(@PathVariable int id) {
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }

    @GetMapping("/getAllMovie")
    public ResponseEntity<List<MovieDTO>> getAllMovie() {
        List<MovieDTO> movieDTOList = movieService.getAllMovie();
        return ResponseEntity.ok(movieDTOList);

    }

    @GetMapping("/admin/checkEmail/{email}")
    public ResponseEntity<Boolean> emailInUse(@PathVariable(value="email") String email)  {
        return new ResponseEntity<>(adminService.emailInUse(email), HttpStatus.OK);
    }

    @GetMapping("/admin/checkPhone/{phone}")
    public ResponseEntity<Boolean> phoneInUse(@PathVariable(value="phone") String phone) throws PhoneALreadyInUseException {
        return new ResponseEntity<>(adminService.phoneInUse(phone), HttpStatus.OK);

    }

    @GetMapping("/admin/auth/{email}/{password}")
    public ResponseEntity<AdminModel> authenticateAdmin(@PathVariable(value="email") String email,
                                                @PathVariable(value="password")String password) {
        return ResponseEntity.ok(adminService.authenticateAdmin(email,password));

    }


}
