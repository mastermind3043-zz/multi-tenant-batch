package org.mordeth.multiTenantBatch.batch.model;

import java.io.Serializable;


public class Car implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7620592014370837928L;

	private Integer serial;
	
	private String brand;
	
	private String color;
	
	private String model;
	
	private String year;
	

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	
	@Override
	public String toString() {
		return "Car [serial=" + serial + ", brand=" + brand + ", color=" + color + ", model=" + model + ", year=" + year
				+  "]";
	}
	

}
