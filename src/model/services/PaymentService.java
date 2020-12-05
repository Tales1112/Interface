package model.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Entities.Contract;
import Entities.Installment;

public class PaymentService {
	private double valueContract;
	private int numberInstallments;
	private OnlineTaxService taxService;

	public PaymentService(double valueContract, int numberInstallments, OnlineTaxService taxService) {
		this.valueContract = valueContract;
		this.taxService = taxService;
		this.numberInstallments = numberInstallments;
	}

	public double getValueContract() {
		return valueContract;
	}

	public void setValueContract(double valueContract) {
		this.valueContract = valueContract;
	}

	public int getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(int numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

	public OnlineTaxService getTaxService() {
		return taxService;
	}

	public void setTaxService(OnlineTaxService taxService) {
		this.taxService = taxService;
	}

	
	public void processContract(Contract contract) {
		double test = valueContract / numberInstallments;
        
		for (int i = 0; i < numberInstallments; i++) {
			double tax = taxService.Tax(test, (i + 1));
			 Date dueDate = addMonths(contract.getDate(), (i + 1));
			contract.getInstallments().add(new Installment(dueDate, tax));

		}

	}
	private Date addMonths(Date date, int N) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, N);
		return calendar.getTime();
	}
}
