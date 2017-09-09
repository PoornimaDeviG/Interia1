package com.niit.Backend.Model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
@Component
public class Product {
	@Id
	private String pid;
	private String pname;
	private String pdiscription;
	private int pquantity;
	private float pprice;
	@Transient
	private MultipartFile pimg;
	public MultipartFile getPimg() {
		return pimg;
	}
	public void setPimg(MultipartFile pimg) {
		this.pimg = pimg;
	}
	@ManyToOne
	@JoinColumn(name="cid")
	private Category category;
	@ManyToOne
	@JoinColumn(name="sid")
	private Supplier supplier; 
	public Product()
	{
		this.pid="PRO"+UUID.randomUUID().toString().substring(30).toUpperCase();
	}
	public String getPid() {
		return pid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdiscription() {
		return pdiscription;
	}
	public void setPdiscription(String pdiscription) {
		this.pdiscription = pdiscription;
	}
	public int getPquantity() {
		return pquantity;
	}
	public void setPquantity(int pquantity) {
		this.pquantity = pquantity;
	}
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
}