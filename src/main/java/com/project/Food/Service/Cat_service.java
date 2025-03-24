package com.project.Food.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.project.Food.Entity.Category;


@Service
public interface Cat_service {
	public Category adddata( Category category );
	public List<Category> getdata();
	public Category upddata( Category category,  long cat_id ) ;
	public ResponseEntity<Category> deletedata(  long cat_id );
		
}
