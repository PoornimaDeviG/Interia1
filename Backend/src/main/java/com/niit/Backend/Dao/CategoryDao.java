package com.niit.Backend.Dao;

import java.util.List;


import com.niit.Backend.Model.Category;

public interface CategoryDao {
public boolean saveorupdate(Category cat);
public boolean delete(Category cat);
public Category get(String catId);
public List<Category> list();
}
