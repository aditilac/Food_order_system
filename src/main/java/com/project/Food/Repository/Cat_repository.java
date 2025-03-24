package com.project.Food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Food.Entity.Category;

@Repository
public interface Cat_repository extends JpaRepository<Category, Long>  {

}
