package com.oracelwpd.ddbookmarket.model;

import java.io.Serializable;
import java.util.Date;

public class BookType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double price;
	private String author;
	private String cbs;
	private Date cdDate;
	private String descri;
	private int sid;
	private String photo;
	
	public BookType() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCbs() {
		return cbs;
	}

	public void setCbs(String cbs) {
		this.cbs = cbs;
	}

	public Date getCdDate() {
		return cdDate;
	}

	public void setCdDate(Date cdDate) {
		this.cdDate = cdDate;
	}

	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
}
