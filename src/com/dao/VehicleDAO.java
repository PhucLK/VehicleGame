/**
 * 
 *
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Airplane;
import com.model.Car;
import com.model.Ship;
import com.model.Vehicle;
import com.util.JdbcConection;
import com.util.SQLCommand;

/**
 * @author PhucTV7
 *
 */
public class VehicleDAO {

	private static PreparedStatement preparedStatement;
	private static Connection connection;
	private static ResultSet resultSet;

	/**
	 * @param vehicles
	 *
	 * @return
	 */
	// insert
	public static String insertVehicle(List<Vehicle> vehicles) {
		String id = "";
		String query = SQLCommand.QUERY_FIND_ALL;
		try {
			connection = JdbcConection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			resultSet = preparedStatement.executeQuery();
			resultSet.moveToInsertRow();

			for (Vehicle v : vehicles) {
				resultSet.updateString(1, v.getVehicleID());
				resultSet.updateString(2, v.getVehicleType());
				resultSet.updateString(3, v.getVehicleName());
				resultSet.updateFloat(4, v.getWeight());
				resultSet.updateString(5, v.getColor());
				resultSet.updateInt(6, v.getLimitSpeed());
				resultSet.updateBoolean(7, v.isControlled());
				resultSet.insertRow();
			}

			while (resultSet.next()) {
				id = resultSet.getString(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return id;

	}

	/**
	 * @param vehicleID
	 * @param isControlled
	 * @return
	 */
	public static boolean updateVehicle(String vehicleID, boolean a) {

		String query = SQLCommand.QUERY_FIND_ONE;
		try {
			connection = JdbcConection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			preparedStatement.setString(1, vehicleID);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				resultSet.updateBoolean("isControlled", a);
				resultSet.rowUpdated();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return false;

	}

	/**
	 * @return
	 */
	public static List<Vehicle> getVehicles() {

		List<Vehicle> list = new ArrayList<Vehicle>();
		String query = SQLCommand.QUERY_FIND_ALL;
		try {
			connection = JdbcConection.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				if (resultSet.getString("vehicleType").equalsIgnoreCase("Airplane")) {
					Vehicle vehicle = new Airplane(resultSet.getString(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getFloat(4), resultSet.getString(5), resultSet.getInt(6),
							resultSet.getBoolean(7));
					list.add(vehicle);
				}

				if (resultSet.getString("vehicleType").equalsIgnoreCase("Car")) {
					Vehicle vehicle = new Car(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getFloat(4), resultSet.getString(5), resultSet.getInt(6),
							resultSet.getBoolean(7));
					list.add(vehicle);
				}

				if (resultSet.getString("vehicleType").equalsIgnoreCase("Ship")) {
					Vehicle vehicle = new Ship(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3),
							resultSet.getFloat(4), resultSet.getString(5), resultSet.getInt(6),
							resultSet.getBoolean(7));
					list.add(vehicle);
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return list;

	}

}
