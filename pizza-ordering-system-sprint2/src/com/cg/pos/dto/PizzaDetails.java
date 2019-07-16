package com.cg.pos.dto;

public class PizzaDetails {

	private String storeName;
	private int itemId;
	private int qty;
	private double price;

	public PizzaDetails(String storeName, int itemId, int qty, double price) {
		super();
		this.storeName = storeName;
		this.itemId = itemId;
		this.qty = qty;
		this.price = price;
	}

	public PizzaDetails() {
		
	}

	// Getter and Setter to Access private Member
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "StoreName=" + storeName + "\n ItemId=" + itemId + "\n Qty=" + qty + "\n Price=" + price + "\n";
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
