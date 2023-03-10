package com.app.dairydelight.model;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "order_detail")

public class OrderDetail extends BaseEntity {
	private int quantity;

	private double totalPrice;


	public OrderDetail(int quantity, double totalPrice) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;

	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "OrderDetail [quantity=" + quantity + ", totalPrice=" + totalPrice + "]";
	}
	
}
