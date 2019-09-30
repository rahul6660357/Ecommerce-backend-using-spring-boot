package com.caseStudy.Ecommerce.Repository;

import com.caseStudy.Ecommerce.Model.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepositry extends JpaRepository<Items, Long>{
}
