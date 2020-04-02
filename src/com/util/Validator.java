/**
 * 
 *
 */
package com.util;

import com.exception.DataNotMatchException;

/**
 * @author PhucTV7
 *
 */
public class Validator {

	/**
	 * @param value
	 * @return true if valid float value, otherwise return false
	 * @throws DataNotMatchException
	 */
	public static boolean isFloat(String value) throws DataNotMatchException {

		try {
			float a = Float.valueOf(value);
		} catch (Exception e) {
			// TODO: handle exception
			throw new DataNotMatchException();
		}

		return true;
	}

	/**
	 * @param value
	 * @return true if valid int value, otherwise return false
	 * @throws DataNotMatchException
	 */
	public static boolean isInt(String value) throws DataNotMatchException {
		try {
			int a = Integer.valueOf(value);
		} catch (Exception e) {
			// TODO: handle exception
			throw new DataNotMatchException();
		}

		return true;
	}

}
