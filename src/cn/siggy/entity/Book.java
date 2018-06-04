package cn.siggy.entity;

import java.util.Date;

public class Book {
	private int id;
	private String name;
	private double price;
	private String author;
	private Date pubDate;
	private int categoryId;
	public Book() {
	}
	public Book(String name, double price, String author, Date pubDate,int categoryId) {
		super();
		this.name = name;
		this.price = price;
		this.author = author;
		this.pubDate = pubDate;
		this.categoryId = categoryId;
	}
	public Book(int id, String name, double price, String author, Date pubDate, int categoryId) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.author = author;
		this.pubDate = pubDate;
		this.categoryId = categoryId;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", author=" + author + ", pubDate=" + pubDate
				+ ", categoryId=" + categoryId + "]";
	}
	
	
	
	
}
