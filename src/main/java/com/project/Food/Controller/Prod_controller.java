package com.project.Food.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.Food.Entity.Product;
import com.project.Food.Service.Prod_services;

@RestController
@RequestMapping("/api/product")

public class Prod_controller {
	
	
	@Autowired
	Prod_services prod_services;
	
	
	@PostMapping("/addprod")
	public Product addproduct(@RequestParam(name="file", required=false) MultipartFile product_img,
			@RequestParam(name="ProductName", required=false) String prod_name,
			@RequestParam(name="ProductPrice", required=false) String prod_price,
			@RequestParam(name="ProductQuantity", required=false) String prod_quantity,
			@RequestParam(name="category", required=false) String category
			)
	{
		return this.prod_services.addproduct(product_img, prod_name, prod_price, prod_quantity,category);
		
	}

	@GetMapping("/getprod")
	public List<Product> getproduct(){
		return this.prod_services.getproduct();
	}
	
	
	public Product updproduct(@RequestBody Product product, @PathVariable("prod_id") Long prod_id) {
		return this.prod_services.updproduct(product, prod_id);
		
	}
}
