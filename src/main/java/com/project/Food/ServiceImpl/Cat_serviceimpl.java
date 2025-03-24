package com.project.Food.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.Food.Entity.Category;
import com.project.Food.Exception.ResourceNotFoundException;
import com.project.Food.Repository.Cat_repository;
import com.project.Food.Service.Cat_service;

@Service
public class Cat_serviceimpl implements Cat_service {

	@Autowired
	Cat_repository cat_repository;
	@Override
	public Category adddata(Category category) {
		// TODO Auto-generated method stub
		return this.cat_repository.save(category);
	}
	@Override
	public List<Category> getdata() {
		// TODO Auto-generated method stub
		return this.cat_repository.findAll();
	}
	@Override
	public Category upddata(Category category, long cat_id) {
		Category existingcategory=this.cat_repository.findById(cat_id)
				.orElseThrow(()-> new ResourceNotFoundException("update data" +cat_id));
		existingcategory.setCat_name(category.getCat_name());
		// TODO Auto-generated method stub
		return this.cat_repository.save(existingcategory);
	}
	@Override
	public ResponseEntity<Category> deletedata(long cat_id) {
		Category existingcategory=this.cat_repository.findById(cat_id)
				.orElseThrow(()-> new ResourceNotFoundException("update data" +cat_id));
		this.cat_repository.delete(existingcategory);
		return  ResponseEntity.ok().build();
	}

}
