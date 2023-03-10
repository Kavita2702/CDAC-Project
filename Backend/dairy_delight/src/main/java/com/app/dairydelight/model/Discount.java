package com.app.dairydelight.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "discount")
public class Discount extends BaseEntity {
	
	@Column(name = "name", length = 20)
	private String name;
	

	@Column(length=50)
	private String description;
	
	private double disc_percent;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getDisc_percent() {
		return disc_percent;
	}



	public void setDisc_percent(double disc_percent) {
		this.disc_percent = disc_percent;
	}



	@Override
	public String toString() {
		return "Discount [name=" + name + ", description=" + description + ", disc_percent=" + disc_percent + "]";
	}
	
	

}
