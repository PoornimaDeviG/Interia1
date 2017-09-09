package com.niit.Backend.Dao;
import java.util.List;

import com.niit.Backend.Model.Shipping;


public interface ShippingDao {
public boolean saveorupdate(Shipping ship);
public boolean delete(Shipping ship);
public Shipping get(String shipId);
public List<Shipping> list();
public List<Shipping> getaddbyUser(String uid);
}
