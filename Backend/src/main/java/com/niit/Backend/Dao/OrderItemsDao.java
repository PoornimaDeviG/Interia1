package com.niit.Backend.Dao;
import java.util.List;


import com.niit.Backend.Model.OrderItems;

	public interface OrderItemsDao{
		public boolean saveorupdate(OrderItems orderit);
		public boolean delete(OrderItems orderit);
		public OrderItems get(String orderitemId);
		public List<OrderItems> list();
		}


