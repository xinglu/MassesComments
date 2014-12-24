package com.comments.vo;

public class FoodImg {
	
	private int foodimgid;
	private int foodphotoid;
	private String foodimgname;
	
	public FoodImg(int foodimgid, int foodphotoid, String foodimgname) {
		super();
		this.foodimgid = foodimgid;
		this.foodphotoid = foodphotoid;
		this.foodimgname = foodimgname;
	}

	public int getFoodimgid() {
		return foodimgid;
	}

	public void setFoodimgid(int foodimgid) {
		this.foodimgid = foodimgid;
	}

	public int getFoodphotoid() {
		return foodphotoid;
	}

	public void setFoodphotoid(int foodphotoid) {
		this.foodphotoid = foodphotoid;
	}

	public String getFoodimgname() {
		return foodimgname;
	}

	public void setFoodimgname(String foodimgname) {
		this.foodimgname = foodimgname;
	}
	
	
}
