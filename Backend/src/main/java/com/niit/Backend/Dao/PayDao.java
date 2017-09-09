package com.niit.Backend.Dao;

import java.util.List;


import com.niit.Backend.Model.Pay;
	public interface PayDao {
	public boolean saveorupdate(Pay pay);
	public boolean delete(Pay pay);
	public Pay get(String payId);
	public List<Pay> list();
	}


