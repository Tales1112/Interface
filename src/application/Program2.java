package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entities.Contract;
import Entities.Installment;
import model.services.PaymentService;
import model.services.PaypalTaxService;

public class Program2 {
	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		try {
			System.out.println("Enter contract Data");
			System.out.println("Number: ");
			int numb = sc.nextInt();
			System.out.println("Date: ");
			Date d1 = sdf.parse(sc.next());
			Contract c1 = new Contract(numb, d1);

			System.out.println("Contract value: ");
			double value = sc.nextDouble();
			System.out.println("Enter number of installments");
			int install = sc.nextInt();
			PaymentService p1 = new PaymentService(value, install, new PaypalTaxService());
			p1.processContract(c1);
			System.out.println("Installmnets: ");

			for (Installment t1 : c1.getInstallments()) {
				System.out.println("Date: ");
				System.out.println(t1.getDueDate());
				System.out.println(t1.getAmount());
			}
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}
}
