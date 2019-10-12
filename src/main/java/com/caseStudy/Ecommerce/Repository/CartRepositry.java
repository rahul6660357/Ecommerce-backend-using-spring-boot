package com.caseStudy.Ecommerce.Repository;

import com.caseStudy.Ecommerce.Model.Cart;
import com.caseStudy.Ecommerce.Model.Items;
import com.caseStudy.Ecommerce.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepositry  extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUsersAndItems(Optional<Users> user, Optional<Items> item);

   List<Cart> findByUsersAndItems_Active(Optional<Users> user, int i);


    List<Cart> findAllByUsers(Users users);
}
