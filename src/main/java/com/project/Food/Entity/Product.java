package com.project.Food.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity

public class Product {

	@Id
	@GeneratedValue
	
	private long prod_id;
	private String prod_name;
	private double prod_price;
	private int prod_quantity;
	@Lob
	private byte[] product_img;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="category")
	@JsonProperty(access =Access.WRITE_ONLY)
	private Category category;
	
	public Product() {
		
	}

	public Product(long prod_id, String prod_name, double prod_price, int prod_quantity, byte[] product_img,
			Category category) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
		this.product_img = product_img;
		this.category = category;
	}

	public long getProd_id() {
		return prod_id;
	}

	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public double getProd_price() {
		return prod_price;
	}

	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}

	public byte[] getProduct_img() {
		return product_img;
	}

	public void setProduct_img(byte[] product_img) {
		this.product_img = product_img;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

	
	
	
}
