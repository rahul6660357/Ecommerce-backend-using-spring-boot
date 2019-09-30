package com.caseStudy.Ecommerce.Controller;


import com.caseStudy.Ecommerce.Model.Items;
import com.caseStudy.Ecommerce.Repository.ItemRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


@Autowired
ItemRepositry itemRepository;
    @GetMapping("/productdetails")
    public List<Items> getAllNotes() {
        return itemRepository.findAll();
    }
    @PostMapping("/productdetails")
    public Items createNote(@Valid @RequestBody Items item) {
        return itemRepository.save(item);
    }

}
