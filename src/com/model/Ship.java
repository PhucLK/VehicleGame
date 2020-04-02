/**
 * 
 *
 */
package com.model;

/**
 * @author PhucTV7 15/08/1994
 *
 */
public class Ship extends Vehicle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Ship() {
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
	public Ship(String vehicleID, String vehicleType, String vehicleName, float weight, String color, int limitSpeed,
			boolean isControlled) {
		super(vehicleID, vehicleType, vehicleName, weight, color, limitSpeed, isControlled);

	}

	@Override
	public boolean drive(int speed) {
		if (speed < super.getLimitSpeed()) {
			super.setControlled(true);
			runOnWater();
			return true;
		}
		return false;
	}

	public void runOnWater() {
		System.out.println("I can run on the water.");
	}

}
