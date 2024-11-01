package com.prod.one;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<ProductModel,Integer> {
    List<ProductModel> findByCreatedDateOrderByCustomerId(LocalDate createdDate);

}
