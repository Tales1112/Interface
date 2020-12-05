package model.services;

public class PaypalTaxService implements OnlineTaxService {


@Override
	public double Tax(double amount, double d) {
		double result = amount * (Math.pow(1.01, d));
		
		return result *= 1.02;
	}

}
