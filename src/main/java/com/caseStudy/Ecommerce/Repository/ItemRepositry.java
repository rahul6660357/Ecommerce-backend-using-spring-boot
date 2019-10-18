package com.caseStudy.Ecommerce.Repository;

import com.caseStudy.Ecommerce.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepositry extends JpaRepository<Items, Long>{


    List<Items> findAllByNameContaining(String name);
    List<Items> findAllByCatogory(String catogory);
    List<Items> findAllByPriceBefore(Double price);
    List<Items> findAllByPriceBetween(Double price1, Double price2);
    List<Items> findAllByPriceBetweenAndCatogory(Double price1, Double price2, String Catogory);
}
