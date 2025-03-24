package com.project.Food.ServiceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.project.Food.Entity.Category;
import com.project.Food.Entity.Product;
import com.project.Food.Exception.ResourceNotFoundException;
import com.project.Food.Repository.Cat_repository;
import com.project.Food.Repository.Prod_repository;
import com.project.Food.Service.Prod_services;

@Service
public class Prod_serviceImpl implements Prod_services {

	@Autowired
	Prod_repository prod_repository;

	@Autowired
	Cat_repository cat_repository;

	@Override
	public Product addproduct(MultipartFile product_img, String prod_name, String prod_price, String prod_quantity,
			String category) {

		Product prod = new Product();

		try {
			prod.setProd_name(prod_name);
			prod.setProd_price(Double.parseDouble(prod_price));
			prod.setProd_quantity(Integer.parseInt(prod_quantity));
			prod.setProduct_img(product_img.getBytes());
			
			Category catID=this.cat_repository.getById(Long.parseLong(category));
			
			prod.setCategory(catID);
			return this.prod_repository.save(prod);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return prod;
		}

	}

	@Override
	public List<Product> getproduct() {
		// TODO Auto-generated method stub
		return this.prod_repository.findAll();
	}

	@Override
	public Product updproduct(Product product, Long prod_id) {
		// TODO Auto-generated method stub
		
		Product existingprod=this.prod_repository.findById(prod_id).
				orElseThrow(()->new ResourceNotFoundException("update data" +prod_id));
		existingprod.setProd_id(product.getProd_id());
		existingprod.setProd_name(product.getProd_name());
		existingprod.setProd_price(product.getProd_price());
		existingprod.setProd_quantity(product.getProd_quantity());
		// @formatter:on

		return this.prod_repository.save(existingprod);
	}



	
	
	

}
