/**
 * 
 *
 */
package com.exception;

/**
 * @author PhucTV7
 *
 */
public class VehicleDuplicateException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public VehicleDuplicateException() {
	}

	/**
	 * @param message
	 */
	public VehicleDuplicateException(String message) {
		super(message);
	}
}
