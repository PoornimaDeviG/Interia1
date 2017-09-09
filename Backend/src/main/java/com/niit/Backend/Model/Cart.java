package com.niit.Backend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Cart {
	@Id
	private String Cart_Id;
	private Double Grand_Total=0.0;
	private int Total_Items=0;
	
	@OneToMany(mappedBy="cart")
	private List<CartItems> cartitems;
	public Cart()
	{
		this.Cart_Id="CART"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	
	public List<CartItems> getCartitems() {
		return cartitems;
	}
	public void setCartitems(List<CartItems> cartitems) {
		this.cartitems = cartitems;
	}
	public String getCart_Id() {
		return Cart_Id;
	}
	public void setCart_Id(String cart_Id) {
		Cart_Id = cart_Id;
	}
	public Double getGrand_Total() {
		return Grand_Total;
	}
	public void setGrand_Total(Double grand_Total) {
		Grand_Total = grand_Total;
	}
	public int getTotal_Items() {
		return Total_Items;
	}
	public void setTotal_Items(int total_Items) {
		Total_Items = total_Items;
	}
}
