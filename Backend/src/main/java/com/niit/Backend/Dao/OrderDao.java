package com.niit.Backend.Dao;
import java.util.List;


import com.niit.Backend.Model.Order;
	public interface OrderDao {
	public boolean saveorupdate(Order order);
	public boolean delete(Order order);
	public Order get(String orderId);
	public List<Order> list();
	}


