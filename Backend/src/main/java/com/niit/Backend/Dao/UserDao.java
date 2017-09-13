package com.niit.Backend.Dao;

import java.util.List;


import com.niit.Backend.Model.User;

public interface UserDao {
public boolean saveorupdate(User user);
public boolean delete(User user);
public User get(String uid);
public List<User> list();
public User isValid(String uemail, String pwd);
public User getUseremail(String uemail);
}
