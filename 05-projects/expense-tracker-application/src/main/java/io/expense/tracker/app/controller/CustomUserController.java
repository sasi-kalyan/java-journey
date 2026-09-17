package io.expense.tracker.app.controller;

import io.expense.tracker.app.entity.CustomUser;
import io.expense.tracker.app.model.CustomUserDTO;
import io.expense.tracker.app.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/v1")
public class CustomUserController {

    private CustomUserService customUserService;

    @Autowired
    CustomUserController(CustomUserService invokeCustomUserService){
        customUserService = invokeCustomUserService;
    }

    @PostMapping("/new-user")
    public ResponseEntity<CustomUserDTO> createNewUser(@RequestBody CustomUserDTO customUserDTO){
        CustomUserDTO customUserDTO1 = customUserService.createNewUser(customUserDTO);
        ResponseEntity<CustomUserDTO> responseEntity = new ResponseEntity<>(customUserDTO1, HttpStatus.CREATED);
        return responseEntity;
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<Boolean> deleteExistingUser(@PathVariable("id")Long id){
        boolean deleteFlag = customUserService.deleteExisingUser(id);
        ResponseEntity<Boolean> responseEntity = new ResponseEntity<>(deleteFlag, HttpStatus.GONE);
        return responseEntity;
    }

    @PostMapping("/update-user/{id}")
    public ResponseEntity<CustomUserDTO> updateExistingUser(@PathVariable Long id, @RequestBody CustomUserDTO customUserDTO){
        CustomUserDTO customUserDTO1 = customUserService.updateExistingUser(id, customUserDTO);
        ResponseEntity<CustomUserDTO> responseEntity = new ResponseEntity<>(customUserDTO1, HttpStatus.CREATED);
        return responseEntity;
    }
}
