package com.project.Food.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Food.Entity.Category;
import com.project.Food.Service.Cat_service;

@RequestMapping("/api/category")
@RestController
public class Cat_controller {
	
	@Autowired
	
	Cat_service cat_service;
	
	
	@PostMapping("/foodadd")
	public Category adddata(@RequestBody Category category ) {
		return this.cat_service.adddata(category);
		
	}
	
	@GetMapping("/foodget")
	public List<Category> getdata(){
		return this.cat_service.getdata();
		
	}
	
	@PutMapping("/update/{id}")
	public Category upddata(@RequestBody Category category, @PathVariable ("id") long cat_id ) {
		return this.cat_service.upddata(category, cat_id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Category> deletedata( @PathVariable ("id") long cat_id ){
		return this.cat_service.deletedata(cat_id);
		
	}
	

}
