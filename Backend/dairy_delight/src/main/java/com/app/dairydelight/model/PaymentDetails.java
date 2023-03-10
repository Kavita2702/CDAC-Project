package com.app.dairydelight.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment_details")
public class PaymentDetails extends BaseEntity{
	
	
	private double amount;
	
	@Column(length = 20)
	private String provider;
	private LocalDate paymentDate;
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "PaymentDetails [amount=" + amount + ", provider=" + provider + ", paymentDate=" + paymentDate + "]";
	}
	

}
