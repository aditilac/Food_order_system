package com.project.Food.Service;




import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.project.Food.Entity.Product;

public interface Prod_services {
	
	public Product addproduct( MultipartFile product_img,
			 String prod_name,
			 String prod_price,
			 String prod_quantity,
			 String category
			);
	public List<Product> getproduct();
	public Product updproduct( Product product,  Long prod_id);
}
