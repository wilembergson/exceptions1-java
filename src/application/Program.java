package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exception.DemainsException;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = scan.nextInt();
			System.out.print("Check-in date (dd/MM/yy): ");
			Date checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yy): ");
			Date checkout = sdf.parse(scan.next());

			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yy): ");
			checkout = sdf.parse(scan.next());

			reservation.updateDates(checkin, checkout);
			System.out.println("Reservation: " + reservation);
		} 
		catch (ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch(DemainsException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		scan.close();
	}
}
