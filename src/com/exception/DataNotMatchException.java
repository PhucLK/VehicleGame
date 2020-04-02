/**
 * 
 *
 */
package com.exception;

/**
 * @author PhucTV7
 *
 */
public class DataNotMatchException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public DataNotMatchException() {
	}

	/**
	 * @param message
	 */
	public DataNotMatchException(String message) {
		super(message);
	}
}
