package com.project.Food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Food.Entity.Product;


@Repository
public interface Prod_repository extends JpaRepository<Product, Long> {

}
