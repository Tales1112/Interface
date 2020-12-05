package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.CarRental;
import Entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

		System.out.println("Enter rental data: ");
		System.out.println("Car model: ");
		String model = sc.nextLine();
		System.out.println("Pickup start date");
		Date d1 = sdf.parse(sc.nextLine());
		System.out.println("Return: ");
		Date d2 = sdf.parse(sc.nextLine());
		CarRental c1 = new CarRental(d1, d2, new Vehicle(model));

		System.out.println("Enter price per hour: ");
		double phour = sc.nextDouble();
		System.out.println("Enter price per day ");
		double pricePerDay = sc.nextDouble();
		RentalService r1 = new RentalService(pricePerDay, phour, new BrazilTaxService());
		System.out.println("INVOICE: ");

		r1.processInvoice(c1);

		System.out.println("Basic payment" + c1.getInvoice().getBasicPayment());
		System.out.println("Tax:" + c1.getInvoice().getTax());
		System.out.println("Total Payment" + c1.getInvoice().getTotalPayment());

		sc.close();
	}

}
