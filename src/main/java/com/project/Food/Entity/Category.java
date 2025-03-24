package com.project.Food.Entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Category {
	@Id
	@GeneratedValue
	
	
	private long cat_id;
	private String cat_name;
	
	@OneToMany(mappedBy="category" , cascade=CascadeType.ALL)
	private List<Product> product=new ArrayList<Product>();
	
	public  Category() {
		
	}

	public Category(long cat_id, String cat_name, List<Product> product) {
		super();
		this.cat_id = cat_id;
		this.cat_name = cat_name;
		this.product = product;
	}

	public long getCat_id() {
		return cat_id;
	}

	public void setCat_id(long cat_id) {
		this.cat_id = cat_id;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}


}
