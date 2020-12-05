package model.services;

public class USAInterestService2 implements InterestService{
	private double interestRate;

	public USAInterestService2(double interestRate) {

		this.interestRate = interestRate;
	}
@Override
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

}
