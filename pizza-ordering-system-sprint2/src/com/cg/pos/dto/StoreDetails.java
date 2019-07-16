package com.cg.pos.dto;

public class StoreDetails {
	private int storeId;
	private String storeName;
	private String storeAddress;
	private String storeContact;
	private String ownerName;

	public StoreDetails(int storeId, String storeName, String storeAddress, String storeContact, String ownerName) {

		this.storeId = storeId;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storeContact = storeContact;
		this.ownerName = ownerName;
	}

	// Getter and Setter to Access private Member
	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreContact() {
		return storeContact;
	}

	public void setStoreContact(String storeContact) {
		this.storeContact = storeContact;
	}

	@Override
	public String toString() {
		return "StoreDetails: \n StoreId=" + storeId + "\n" + "StoreName=" + storeName + "\n" + "StoreAddress="
				+ storeAddress + "\n" + "StoreContact=" + storeContact + "\n" + "OwnerName=" + ownerName + "\n";
	}

}
