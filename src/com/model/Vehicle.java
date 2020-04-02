/**
 * 
 *
 */
package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.exception.DataNotMatchException;
import com.exception.VehicleDuplicateException;
import com.util.Validator;

/**
 * @author PhucTV7 15/08/1994
 *
 */
public abstract class Vehicle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String vehicleID;
	private String vehicleType;
	private String vehicleName;
	private float weight;
	private String color;
	private int limitSpeed;
	private boolean isControlled;
	private static Set<String> vehicleIDs = new HashSet<String>();

	/**
	 * 
	 */
	public Vehicle() {
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
	public Vehicle(String vehicleID, String vehicleType, String vehicleName, float weight, String color, int limitSpeed,
			boolean isControlled) {
		super();
		this.vehicleID = vehicleID;
		this.vehicleType = vehicleType;
		this.vehicleName = vehicleName;
		this.weight = weight;
		this.color = color;
		this.limitSpeed = limitSpeed;
		this.isControlled = isControlled;
	}

	/**
	 * @return the vehicleID
	 */
	public String getVehicleID() {
		return vehicleID;
	}

	/**
	 * @param vehicleID the vehicleID to set
	 * @throws VehicleDuplicateException
	 */
	public void setVehicleID(String vehicleID) throws VehicleDuplicateException {
		if (!vehicleIDs.contains(vehicleID)) {
			this.vehicleID = vehicleID;
			vehicleIDs.add(vehicleID);
		} else
			throw new VehicleDuplicateException("Vehicle " + vehicleName + "has duplicate ID");

	}

	/**
	 * @return the vehicleType
	 */
	public String getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType the vehicleType to set
	 */
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @return the vehicleName
	 */
	public String getVehicleName() {
		return vehicleName;
	}

	/**
	 * @param vehicleName the vehicleName to set
	 */
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	/**
	 * @return the weight
	 */
	public float getWeight() {

		return weight;
	}

	/**
	 * @param weight the weight to set
	 * @throws DataNotMatchException
	 */
	public void setWeight(String weight) throws DataNotMatchException {
		if (Validator.isFloat(weight)) {
			this.weight = Float.valueOf(weight);
		} else {
			throw new DataNotMatchException("Input mismatch data!!!");
		}
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the limitSpeed
	 */
	public int getLimitSpeed() {
		return limitSpeed;
	}

	/**
	 * @param limitSpeed the limitSpeed to set
	 * @throws DataNotMatchException
	 */
	public void setLimitSpeed(String limitSpeed) throws DataNotMatchException {
		if (Validator.isInt(limitSpeed)) {
			this.limitSpeed = Integer.valueOf(limitSpeed);
		} else {
			throw new DataNotMatchException("Input mismatch data!!!");
		}
	}

	/**
	 * @return the isControlled
	 */
	public boolean isControlled() {
		return isControlled;
	}

	/**
	 * @param isControlled the isControlled to set
	 */
	public void setControlled(boolean isControlled) {
		this.isControlled = isControlled;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "VehicleID : " + vehicleID + "|vehicleType : " + vehicleType + "|vehicleName : " + vehicleName
				+ "|weight : " + weight + "|color : " + color + "|limitSpeed : " + limitSpeed + "|isControlled "
				+ isControlled;
	}

	/**
	 * @param speed
	 * @return
	 */
	public abstract boolean drive(int speed);

}
