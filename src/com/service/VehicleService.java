/**
 * 
 *
 */
package com.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.model.Airplane;
import com.model.Car;
import com.model.Ship;
import com.model.Vehicle;
import com.util.Constant;

/**
 * @author PhucTV7
 *
 */
public class VehicleService {

	/**
	 * @param s
	 * @return
	 */
	public static List<Vehicle> getVehicles() {

		List<Vehicle> vehicles = new ArrayList<>();
		BufferedReader bufferedReader = null;
		int count = 0;
		try {
			File fileDir = new File(Constant.filepath);

			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF8"));

			String str = "";

			while ((str = bufferedReader.readLine()) != null) {

				count++;
				if (count > 1) {
					String[] s = str.split(",");

					if (s[1].equalsIgnoreCase("Airplane")) {
						Vehicle vehicle = new Airplane(s[0], s[1], s[2], Float.valueOf(s[3]), s[4],
								Integer.valueOf(s[5]), false);
						vehicles.add(vehicle);

					}

					if (s[1].equalsIgnoreCase("Car")) {
						Vehicle vehicle = new Car(s[0], s[1], s[2], Float.valueOf(s[3]), s[4], Integer.valueOf(s[5]),
								false);
						vehicles.add(vehicle);
					}

					if (s[1].equalsIgnoreCase("Ship")) {
						Vehicle vehicle = new Ship(s[0], s[1], s[2], Float.valueOf(s[3]), s[4], Integer.valueOf(s[5]),
								false);
						vehicles.add(vehicle);
					}

				}

			}
			return vehicles;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		return vehicles;

	}

	/**
	 * @param l
	 * @return list vehicle sort by limitspeeds
	 */
	public static List<Vehicle> sort(List<Vehicle> l) {
		Collections.sort(l, new VehicalSort());
		return l;
	}

}

class VehicalSort implements Comparator<Vehicle> {

	@Override
	public int compare(Vehicle o1, Vehicle o2) {
		return Integer.valueOf(o1.getLimitSpeed()).compareTo(Integer.valueOf(o2.getLimitSpeed()));
	}

}
