package com.caseStudy.Ecommerce.Service;

import com.caseStudy.Ecommerce.Model.Users;
import com.caseStudy.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CurrentUserservice {

    @Autowired
    UserRepository userRepository;
//
//    public Optional<Users> CurrentUser(Principal principal)
//    {
//        String userid = principal.getName();
//        return userRepository.findbyuserid(userid);
//    }


    public Long getUserid(Principal principal) {
        String email =principal.getName();
        Long id= userRepository.findByEmail(email).get().getUserid();
        return id;
    }
}
