/**
 * 
 *
 */
package com.model;

/**
 * @author PhucTV7 15/08/1994
 *
 */
public class Airplane extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public Airplane() {
		super();

	}

	/**
	 * @param vehicleID
	 * @param vehicleType
	 * @param vehicleName
	 * @param weight
	 * @param color
	 * @param limitSpeed
	 * @param isControlled
	 */
	public Airplane(String vehicleID, String vehicleType, String vehicleName, float weight, String color,
			int limitSpeed, boolean isControlled) {
		super(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isControlled);

	}

	@Override
	public boolean drive(int speed) {
		if (speed < super.getLimitSpeed()) {
			super.setControlled(true);
			fly();
			return true;
		}
		return false;
	}

	public void fly() {
		System.out.println("I can fly in the sky.");
	}

}
