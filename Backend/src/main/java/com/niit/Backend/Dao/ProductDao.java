package com.niit.Backend.Dao;

import java.util.List;

import com.niit.Backend.Model.Category;
import com.niit.Backend.Model.Product;

public interface ProductDao {
public boolean saveorupdate(Product pro);
public boolean delete(Product pro);
public  Product get(String pid);
public List<Product> list();
public List<Product> getProductByCategory(String cid);
public List<Product> getProductBySupplier(String sid);
}
