package com.niit.Backend.Dao;

import java.util.List;

import com.niit.Backend.Model.Billing;


public interface BillingDao {
public boolean saveorupdate(Billing bil);
public boolean delete(Billing bil);
public Billing get(String uId);
public List<Billing> list();
}
