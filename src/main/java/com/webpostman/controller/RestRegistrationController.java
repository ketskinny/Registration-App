package com.webpostman.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webpostman.dto.RegistrationDto;
import com.webpostman.entity.Registration;
import com.webpostman.repository.RegistrationRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/registrations")
public class RestRegistrationController {
    
    @Autowired
    private RegistrationRepository registrationRepo;
    
    
   
    @GetMapping
    public List<Registration> getAllReg(){
        List<Registration> registration =registrationRepo.findAll();
        return registration;
    }

    @DeleteMapping("/{id}")
    public void deleteRegistration(@PathVariable long id ){
        registrationRepo.deleteById(id);
    }


    // save Registration 
    @PostMapping
    public void saveRegistration(@RequestBody Registration reg){
        registrationRepo.save(reg);
    }


    @PutMapping
    public void updateRegistration(@RequestParam long id ,@RequestBody RegistrationDto registrationDto){
        Registration registration = registrationRepo.findById(id).get();

        registration.setFirstname(registrationDto.getFirstname());
        registration.setLastname(registrationDto.getLastname());
        registration.setEmail(registrationDto.getEmail());
        registration.setMobile(registrationDto.getMobile());


        registrationRepo.save(registration);
    }


}
