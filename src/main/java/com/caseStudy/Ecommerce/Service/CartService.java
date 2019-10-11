package com.caseStudy.Ecommerce.Service;

import com.caseStudy.Ecommerce.Model.Cart;
import com.caseStudy.Ecommerce.Model.Items;
import com.caseStudy.Ecommerce.Model.Users;
import com.caseStudy.Ecommerce.Repository.CartRepositry;
import com.caseStudy.Ecommerce.Repository.ItemRepositry;
import com.caseStudy.Ecommerce.Repository.OrderHistoryRepositry;
import com.caseStudy.Ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    ItemRepositry itemRepositry;

    @Autowired
    CartRepositry cartRepositry;

    @Autowired
    UserRepository userRepository;

    public String addtocart(Long userid, Long product_id) {
        Optional<Items> item = itemRepositry.findById(product_id);
        Optional<Users> user = userRepository.findById((userid));
        if (cartRepositry.findByUsersAndItems(user, item).isPresent()) {
           Cart cart= cartRepositry.findByUsersAndItems(user,item).get();
           cart.setQuantity(cart.getQuantity()+1);
           cartRepositry.save(cart);
            return "This item is already present in your cart";
        } else {
            Cart cart = new Cart();
            cart.setItems(item.get());
            cart.setUsers(user.get());
            cart.setQuantity(1);
            cartRepositry.save(cart);
            return "Successfully added";
        }
    }


    public String removefromcart(Long getuserid, Long product_id) {
        Optional<Items> item = itemRepositry.findById(product_id);
        Optional<Users> user = userRepository.findById((getuserid));
        if (cartRepositry.findByUsersAndItems(user, item).get().getQuantity() <= 1) {
            Cart car = cartRepositry.findByUsersAndItems(user,item).get();
            cartRepositry.delete(car);

        }
        else {
          Cart cart=  cartRepositry.findByUsersAndItems(user,item).get();
          cart.setQuantity(cart.getQuantity()-1);
          cartRepositry.save(cart);
        }
        return "successfully removed";
    }

//    public Cart addProduct(Long userid, Long product_id) {
//        Optional<Items> item = itemRepositry.findById(product_id);
//        Optional<Users> user = userRepository.findById(userid);
//
//        if (cartRepositry.findByUsersAndItems(user, item).isPresent()) {
//            Cart cart = (Cart) cartRepositry.findByUsersAndItems(user, item).get();
//            cart.setQuantity(cart.getQuantity() + 1);
//            cartRepositry.save(cart);
//        } else {
//            Cart c = new Cart(item, user, 1);
//            cartRepositry.save(c);
//        }
//        return (Cart) cartRepositry.findByUsersAndItems(user, item).get();
//    }



    public double checkout(Long getuserid, Principal principal) {
        return 0;
    }
//
    public String clearcart(Long getuserid, Principal principal) {
        Optional<Users> users=userRepository.findById(getuserid);
        List<Cart> cartList =cartRepositry.findByUsersAndItems_Active(users,1);
        for (Cart cart : cartList){
            cartRepositry.deleteById(cart.getId());
        }
        return "cart Cleared";
    }

    public List<Cart> showcart(Long userid) {
        Optional<Users> users=userRepository.findById(userid);
        return cartRepositry.findByUsersAndItems_Active(users,1);

    }
}