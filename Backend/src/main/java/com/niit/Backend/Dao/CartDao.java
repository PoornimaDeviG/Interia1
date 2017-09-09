package com.niit.Backend.Dao;

import java.util.List;


import com.niit.Backend.Model.Cart;

public interface CartDao {
public boolean saveorupdate(Cart cart);
public boolean delete(Cart cart);
public Cart get(String cartId);
public List<Cart> list();
}
