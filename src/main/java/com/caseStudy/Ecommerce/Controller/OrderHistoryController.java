package com.caseStudy.Ecommerce.Controller;


import com.caseStudy.Ecommerce.Model.Cart;
import com.caseStudy.Ecommerce.Model.OrderHistory;
import com.caseStudy.Ecommerce.Repository.OrderHistoryRepositry;
import com.caseStudy.Ecommerce.Service.CartService;
import com.caseStudy.Ecommerce.Service.CurrentUserservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping(value = "/order")
public class OrderHistoryController {

    @Autowired
    CartService cartService;
    @Autowired
    OrderHistoryRepositry orderHistoryRepositry;

    @Autowired(required = true)
    CurrentUserservice currentUserservice;

    @Autowired
    public OrderHistoryController(CartService cartService, CurrentUserservice currentUserservice){
        this.cartService=cartService;
        this.currentUserservice=currentUserservice;
    }

    @RequestMapping(value = "/gethistory/receive", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderHistory> gethistory(Principal principal){
        return cartService.getHistory(currentUserservice.getUserid(principal),principal);

    }
}
