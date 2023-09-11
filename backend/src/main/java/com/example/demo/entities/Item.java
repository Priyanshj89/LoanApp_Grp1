package com.example.demo.entities;

public class Item {
	private String item_id;
	private String desc;
	private String status;
	private String item_make;
	private String category;
	private int valuation;
	public String getItem_id() {
		return item_id;
	}
	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getItem_make() {
		return item_make;
	}
	public void setItem_make(String item_make) {
		this.item_make = item_make;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getValuation() {
		return valuation;
	}
	public void setValuation(int valuation) {
		this.valuation = valuation;
	}
	public Item(String item_id, String desc, String status, String item_make, String category, int valuation) {
		super();
		this.item_id = item_id;
		this.desc = desc;
		this.status = status;
		this.item_make = item_make;
		this.category = category;
		this.valuation = valuation;
	}
	public Item() {
		super();
	}
	
}
