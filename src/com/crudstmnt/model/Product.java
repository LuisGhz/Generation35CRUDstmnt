package com.crudstmnt.model;

public class Product {
	private int idProduct;
	private String product;
	private String productName;
	private double productPrice;
	
	public int getIdProduct()
	{
		return idProduct;
	}
	
	public void setIdProduct(int idProduct)
	{
		this.idProduct = idProduct;
	}
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
}
