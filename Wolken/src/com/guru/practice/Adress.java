package com.guru.practice;

public class Adress {
	String city;
	int street;
	String area;
	int pin;
	public Adress(String city, int street, String area, int pin) {
		super();
		this.city = city;
		this.street = street;
		this.area = area;
		this.pin = pin;
	}
	public Adress() {
		super();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Adress)
		{
			Adress ad=(Adress) obj;
			if(this.area.equals(ad.area)&&this.city.equals(ad.city)&&this.pin==ad.pin&&this.street==ad.street)
				return true;
			else
				return false;
				
		}
		else
			throw new IllegalArgumentException("Adress ashte compare madi");
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (this.area+this.city+this.pin+this.street).hashCode();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("City: "+this.city+" Area: "+this.area+" Pin: "+this.pin+" Street: "+this.street);
	}
	
	
	
}
