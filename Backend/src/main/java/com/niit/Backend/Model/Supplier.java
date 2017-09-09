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
public class Supplier {
	@Id
private String sid;
private String sname;
private String saddress;
private String sph;
@OneToMany(mappedBy="supplier" ,cascade=CascadeType.ALL)
private List<Product>product;
public Supplier()
{
	this.sid="SUP"+UUID.randomUUID().toString().substring(30).toUpperCase();
}
public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public String getSph() {
	return sph;
}
public void setSph(String sph) {
	this.sph = sph;
}
public String getSid() {
	return sid;
}
public void setSid(String sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getSaddress() {
	return saddress;
}
public void setSaddress(String saddress) {
	this.saddress = saddress;
}


}
