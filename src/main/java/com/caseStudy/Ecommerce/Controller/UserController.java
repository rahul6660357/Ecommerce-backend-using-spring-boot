package com.caseStudy.Ecommerce.Controller;


import com.caseStudy.Ecommerce.Model.Users;
import com.caseStudy.Ecommerce.Repository.UserRepository;
import com.caseStudy.Ecommerce.ResourcenotFoundException;
import com.caseStudy.Ecommerce.Service.CartService;
import com.caseStudy.Ecommerce.Service.CurrentUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    CartService cartService;
    @Autowired(required = true)
    CurrentUserservice currentUserservice;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/get1")

    public String getallUser(){

        return "\"succesfully logedin\"";
    }

    @PostMapping("/adduser")
    public Users createuser(@Valid @RequestBody Users user) {
        user.setActive(1);
        user.setRole("admin");
        return userRepository.save(user);
    }

    @GetMapping("/getuserdetail")

    public Optional<Users> getUserDetail(Principal principal){

        return cartService.getUserDetail(currentUserservice.getUserid(principal));
    }
    @GetMapping("/getuserrole")

    public String getUserRole(Principal principal){

        return cartService.getUserRole(currentUserservice.getUserid(principal));
    }

    @PutMapping("/updateuser/{userid}")
    public Users updateUser(@PathVariable(value = "userid") Long noteId,
                            @Valid @RequestBody Users userDetails) {

        Users note = userRepository.findById(noteId)
                .orElseThrow(() -> new ResourcenotFoundException("Note", "id", noteId));

        note.setEmail(userDetails.getEmail());
        note.setFirstname(userDetails.getFirstname());
        note.setPassword(userDetails.getPassword());
        note.setLastname(userDetails.getLastname());
        note.setPhnno(userDetails.getPhnno());

        Users updatedNote = userRepository.save(note);
        return updatedNote;
    }


}
