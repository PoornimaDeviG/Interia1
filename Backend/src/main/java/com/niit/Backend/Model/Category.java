package com.niit.Backend.Model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table
@Component
public class Category {
	@Id
private String cid;
private String cname;
@OneToMany(mappedBy="category", cascade=CascadeType.ALL)
private List<Product> product;

public Category()
{
	this.cid="CAT"+UUID.randomUUID().toString().substring(30).toUpperCase();
}

public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public String getCid() {
	return cid;
}
public void setCid(String cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
}
