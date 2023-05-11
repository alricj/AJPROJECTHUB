package com.bcbs.proofconcept.controller;

import com.bcbs.proofconcept.dao.UserInfoDao;
import com.bcbs.proofconcept.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class initatorController {

    private final UserService userservice;

    @GetMapping()
    public String viewUsers() {
        return "index";
    }
    @PostMapping("/adduser")
    @ResponseStatus(HttpStatus.CREATED)
    public String addUser(@RequestBody UserInfoDao userInfo) {
        String status = userservice.addUser(userInfo);
        return "user was successfully created: "+ userInfo.getFirstname();
    }

    @GetMapping(path="/alluser", produces="application/json")
    public ResponseEntity<List<UserInfoDao>> getAllUser() {
        List<UserInfoDao> users = userservice.findUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path="/find/{id}", produces="application/json")
    public ResponseEntity<UserInfoDao>getUserById(@PathVariable Integer id) {
        UserInfoDao userDao = userservice.getUserById(id);
        return new ResponseEntity<>(userDao, HttpStatus.OK);

    }

    @GetMapping(path="/delete/{id}", produces="application/json")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
         String deleteStatus = userservice.deleteById(id);
        return new ResponseEntity<>(deleteStatus, HttpStatus.OK);
    }

}
