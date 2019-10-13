package com.caseStudy.Ecommerce.Repository;

import com.caseStudy.Ecommerce.Model.OrderHistory;
import com.caseStudy.Ecommerce.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderHistoryRepositry extends JpaRepository<OrderHistory,Long> {
    List<OrderHistory> findByUsersAndItems_Active(Optional<Users> users, int i);
}
