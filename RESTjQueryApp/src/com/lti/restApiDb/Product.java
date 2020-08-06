package com.lti.restApiDb;

public class Product {

	private String name;
	private double price;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product( int id, String name, double price) {
		super();
		this.name = name;
		this.price = price;
		this.id = id;
	}
	public Product()
	{
		
	}
	
}