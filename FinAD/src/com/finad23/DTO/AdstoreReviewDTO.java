package com.finad23.DTO;

public class AdstoreReviewDTO {
	private int itemReviewNumber;
	private String itemBuyer;
	private String itemReviewText;
	private String attachedFile;
	private String reviewTitle;
	
	public int getItemReviewNumber() {
		return itemReviewNumber;
	}
	public void setItemReviewNumber(int itemReviewNumber) {
		this.itemReviewNumber = itemReviewNumber;
	}
	public String getItemBuyer() {
		return itemBuyer;
	}
	public void setItemBuyer(String itemBuyer) {
		this.itemBuyer = itemBuyer;
	}
	public String getAttachedFile() {
		return attachedFile;
	}
	public void setAttachedFile(String attachedFile) {
		this.attachedFile = attachedFile;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getItemReviewText() {
		return itemReviewText;
	}
	public void setItemReviewText(String itemReviewText) {
		this.itemReviewText = itemReviewText;
	}

}
