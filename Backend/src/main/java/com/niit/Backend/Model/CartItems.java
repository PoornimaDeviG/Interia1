package com.niit.Backend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class CartItems {
	@Id
	private String Cartitem_Id;
	private float Price;
	@ManyToOne
	@JoinColumn(name="Cart_Id")
	private Cart cart;
	@OneToOne
	@JoinColumn(name="pid")
	private Product product;
	public CartItems()
	{
		this.Cartitem_Id="CITEM"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getCartitem_Id() {
		return Cartitem_Id;
	}
	public void setCartitem_Id(String cartitem_Id) {
		Cartitem_Id = cartitem_Id;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
}
