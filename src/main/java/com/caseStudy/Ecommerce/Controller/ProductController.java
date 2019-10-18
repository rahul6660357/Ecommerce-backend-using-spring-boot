package com.caseStudy.Ecommerce.Controller;


import com.caseStudy.Ecommerce.Model.Items;
import com.caseStudy.Ecommerce.Repository.ItemRepositry;
import com.caseStudy.Ecommerce.ResourcenotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RestController
@RequestMapping("/product")
public class ProductController {


@Autowired
ItemRepositry itemRepository;
    @GetMapping("/productdetails")
    public List<Items> getAllNotes() {
        return itemRepository.findAll();
    }

    @DeleteMapping("/deleteproduct/{id}")
    public String delete(@PathVariable(value = "id") Long noteId){
         itemRepository.deleteById(noteId);
         return "\"deleted Successfully\"";
    }
    @PostMapping("/addproduct")
    public Items createNote(@Valid @RequestBody Items item) {
        return itemRepository.save(item);
    }

    @GetMapping("/productdetails/{id}")
    public Items getNoteById(@PathVariable(value = "id") Long noteId) {
        return itemRepository.findById(noteId)
                .orElseThrow(() -> new ResourcenotFoundException("Note", "id", noteId));
    }

    @GetMapping("/productname/{name}")
    public List<Items> getbyname(@PathVariable(value = "name") String name){
        return  itemRepository.findAllByNameContaining(name);
    }

    @GetMapping("/productcatogory/{catogory}")
    public List<Items> getbycatogory(@PathVariable(value = "catogory") String category){
        return  itemRepository.findAllByCatogory(category);
    }

    @GetMapping("/productprice/{price}")
    public List<Items> getbyprice(@PathVariable(value = "price")Double price){
        return itemRepository.findAllByPriceBefore(price);
    }
    @GetMapping("/productpricebtw/{price1}/{price2}")
    public List<Items> getbypricebtw(@PathVariable(value = "price1")Double price1,@PathVariable(value = "price2")Double price2){
        return itemRepository.findAllByPriceBetween(price1,price2);
    }
    @GetMapping("productpricebtwcat/{price1}/{price2}/{catogory}")
    public List<Items> getbypricebtwcat(@PathVariable(value = "price1")Double price1,@PathVariable(value = "price2")Double price2,@PathVariable(value = "catogory")String category){
      return itemRepository.findAllByPriceBetweenAndCatogory(price1,price2,category);
    }

    @PutMapping("/updateitem/{id}")
    public Items updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Items noteDetails) {

        Items note = itemRepository.findById(noteId)
                .orElseThrow(() -> new ResourcenotFoundException("Note", "id", noteId));

        note.setCatogory(noteDetails.getCatogory());
        note.setSubcatogory(noteDetails.getSubcatogory());
        note.setActive(noteDetails.getActive());
        note.setPrice(noteDetails.getPrice());
        note.setDetails(noteDetails.getDetails());
        note.setImage(noteDetails.getImage());
        note.setName(noteDetails.getName());


        Items updatedNote = itemRepository.save(note);
        return updatedNote;
    }

    @PutMapping("/hide/{id}")
    public String hideitem(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Items noteDetails) {

        Items note = itemRepository.findById(noteId)
                .orElseThrow(() -> new ResourcenotFoundException("Note", "id", noteId));


        note.setActive(noteDetails.getActive());
        Items updatedNote = itemRepository.save(note);
        return "\"updated\"";
    }

}
