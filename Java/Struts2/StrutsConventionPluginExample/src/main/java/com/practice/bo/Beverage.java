package com.practice.bo;

public class Beverage {
	private String name;
	private double price;

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public final double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public final void setPrice(final double price) {
		this.price = price;
	}
}
