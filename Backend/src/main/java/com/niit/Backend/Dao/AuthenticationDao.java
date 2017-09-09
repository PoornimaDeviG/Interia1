package com.niit.Backend.Dao;

import java.util.List;

import com.niit.Backend.Model.Authentication;


public interface AuthenticationDao {
	public boolean saveorupdate(Authentication auth);
	public boolean delete(Authentication auth);
	public Authentication get(String role_id);
	public List<Authentication> list();

}
