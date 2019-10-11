package com.caseStudy.Ecommerce.Controller;

import com.caseStudy.Ecommerce.Model.Cart;
import com.caseStudy.Ecommerce.Service.CartService;
import com.caseStudy.Ecommerce.Service.CurrentUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
     CartService cartService;
    @Autowired(required = true)
     CurrentUserservice currentUserservice;

    @Autowired
    public CartController(CartService cartService, CurrentUserservice currentUserservice){
        this.cartService=cartService;
        this.currentUserservice=currentUserservice;
    }

//@RequestMapping(value = "/removeproduct/receive/{product_id}", method = RequestMethod.GET)
//@ResponseBody
//public Cart removeproduct(@PathVariable Long product_id, Principal principal){
//    return cartService.removeproduct(currentUserservice.getuserid(principal),product_id);
//}

    @RequestMapping(value = "/addproduct/receive/{product_id}", method = RequestMethod.POST)
    @ResponseBody
    public String addtocart(@PathVariable Long product_id, Principal principal){
        return cartService.addtocart( currentUserservice.getUserid(principal),product_id);
    }

    @RequestMapping(value = "/removefromcart/receive/{product_id}", method = RequestMethod.GET)
    @ResponseBody
    public String removefromcart(@PathVariable Long product_id, Principal principal){
        return cartService.removefromcart( currentUserservice.getUserid(principal),product_id);
    }

    @RequestMapping(value = "/showcart/receive", method = RequestMethod.GET)
    @ResponseBody
    public List<Cart> showcart(Principal principal){
        return cartService.showcart( currentUserservice.getUserid(principal));

    }



    @RequestMapping( value = "/checkout/recieve" , method = RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal)
    {
        return cartService.checkout(currentUserservice.getUserid(principal),principal);
    }

    @RequestMapping( value = "/clearcart/recieve" , method = RequestMethod.GET)
    @ResponseBody
    public String clearcart(Principal principal)
    {
        return cartService.clearcart(currentUserservice.getUserid(principal),principal);
    }
}
