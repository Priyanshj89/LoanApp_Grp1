package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "item")
public class Item {

	@Override
	public String toString() {
		return "Item [item_id=" + item_id + ", item_name=" + item_name + ", description=" + description + ", item_make="
				+ item_make + ", category=" + category + ", valuation=" + valuation + "]";
	}

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	private String item_id;

	@Column(name = "item_name")
	private String item_name;

	@Column(name = "description")
	private String description;

	@Column(name = "item_make")
	private String item_make;

	@Column(name = "category")
	private String category;

	@Column(name = "valuation")
	private int valuation;

	public String getItem_id() {
		return item_id;
	}

	public void setItem_id(String item_id) {
		this.item_id = item_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
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

	public Item(String item_id, String description, String status, String item_make, String category, int valuation) {
		super();
		this.item_id = item_id;
		this.description = description;
//		this.status = status;
		this.item_make = item_make;
		this.category = category;
		this.valuation = valuation;
	}

	public Item() {
		super();
	}

}
