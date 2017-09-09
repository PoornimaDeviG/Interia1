package com.niit.Backend.Dao;

import java.util.List;


import com.niit.Backend.Model.Supplier;

public interface SupplierDao {
public boolean saveorupdate(Supplier sup);
public boolean delete(Supplier sup);
public Supplier get(String sid);
public List<Supplier> list();

}
