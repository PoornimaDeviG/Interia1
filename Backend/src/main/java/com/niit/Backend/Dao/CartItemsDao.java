package com.niit.Backend.Dao;
import java.util.List;


import com.niit.Backend.Model.CartItems;
public interface CartItemsDao{
	public boolean saveorupdate(CartItems cartit);
	public boolean delete(CartItems cartit);
	public CartItems get(String cartitemId);
	public List<CartItems> list();
	public CartItems getListall(String Cart_Id,String pid);
	public List<CartItems> getlist(String Cart_Id);
	}
