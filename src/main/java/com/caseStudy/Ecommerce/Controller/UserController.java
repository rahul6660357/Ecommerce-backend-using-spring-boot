package com.caseStudy.Ecommerce.Controller;


import com.caseStudy.Ecommerce.Model.Users;
import com.caseStudy.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get1")

    public String getallUser(){

        return "\"succesfully logedin\"";
    }

    @PostMapping("/adduser")
    public Users createuser(@Valid @RequestBody Users user) {
        user.setActive(1);
        user.setRole("user");
        return userRepository.save(user);
    }
}
