package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = scan.nextInt();
		System.out.print("Check-in date (dd/MM/yy): ");
		Date checkin = sdf.parse(scan.next());
		System.out.print("Check-out date (dd/MM/yy): ");
		Date checkout = sdf.parse(scan.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yy): ");
			checkin = sdf.parse(scan.next());
			System.out.print("Check-out date (dd/MM/yy): ");
			checkout = sdf.parse(scan.next());

			String error = reservation.updateDates(checkin, checkout);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println("Reservation: " + reservation);
			}

		}
		scan.close();
	}
}
