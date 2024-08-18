package com.feanix.system.repository;

import com.feanix.system.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product,String> {

    @Query(value = "SELECT * FROM product WHERE product_name LIKE %?1%", nativeQuery = true)
    public Page<Product> findAll(String searchText, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM product WHERE product_name LIKE %?1%", nativeQuery = true)
    public Long countAll(String searchText);
}
