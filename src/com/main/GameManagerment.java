/**
 * 
 *
 */
package com.main;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dao.VehicleDAO;
import com.model.Vehicle;
import com.service.VehicleService;

/**
 * @author PhucTV7
 *
 */
public class GameManagerment {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String choice = "";

		do {

			getMenu();
			choice = sc.nextLine();
			choice = choice.trim();

			switch (choice) {
			
			case ("1"):
				List<Vehicle> vehicles = VehicleService.getVehicles();
				VehicleDAO.insertVehicle(vehicles);
				Random rand = new Random();

				for (Vehicle v : vehicles) {
					
					int rd = rand.nextInt(1000 + 1 - 100) + 100;
					if (v.drive(rd)) {
						VehicleDAO.updateVehicle(v.getVehicleID(), v.isControlled());
						
					}
					System.out.println(v.isControlled());
				}
				break;
			case ("2"):
				VehicleService.sort(VehicleDAO.getVehicles()).forEach(v -> System.out.println(v.toString()));
				break;
			case ("3"):
				System.out.println("Program has ended");
				break;

			default:
				System.out.println("Your choice not correct");
				break;
			}
		} while (!choice.equalsIgnoreCase("3"));

		sc.close();

	}

	/**
	 * get menu
	 */
	public static void getMenu() {
		System.out.println("=================MENU================");
		System.out.println("1. Drive");
		System.out.println("2. MovingIntroduction");
		System.out.println("3. Exit");
		System.out.print("Your choice : ");
	}
}
