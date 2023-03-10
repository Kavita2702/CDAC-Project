package com.app.dairydelight.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "orders")

public class Order extends BaseEntity {
	@CreationTimestamp
	private LocalDate orderDate;
	
	private LocalDate deliveryDate;
	
	private double totalPrice;
	
	private double shippingFee;
	
	//@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private String orderStatus;

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(double shippingFee) {
		this.shippingFee = shippingFee;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", totalPrice=" + totalPrice
				+ ", shippingFee=" + shippingFee + ", orderStatus=" + orderStatus + "]";
	}
	
}
