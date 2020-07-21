package com.wipro.ccbill.entity;

import java.util.Date;

import com.wipro.ccbill.exception.InputInvalidException;

public class CreditCardBill {
private String creditCardNo;
private String customerId;
private Date billDate;
private Transaction monthTransactions[];
public CreditCardBill(String creditCardNo, String customerId, Date billDate, Transaction monthTransactions[]) {
	this.billDate=billDate;
	this.creditCardNo=creditCardNo;
	this.customerId=customerId;
	this.monthTransactions=monthTransactions;
}
public double getTotalAmount(String transactionType) {
	double totalAmount=0.0;
	if(transactionType.equals("DB")==true||transactionType.equals("CR")==true) {
		for(int i=0;i<monthTransactions.length;i++) {
			if(monthTransactions[i].getTransactionType().equals(transactionType)==true) {
				totalAmount+=monthTransactions[i].getTransactionAmount();
			}
		}
	}
	else {
		return 0;
	}	
	return totalAmount;
}

public String validData() throws InputInvalidException {
	if(creditCardNo==null||creditCardNo.length()!=16||customerId==null||customerId.length()<6)
		throw new InputInvalidException();
	else
		return "valid";
}


public double calculateBillAmount() {
	double dbTotalAmount=0, crTotalAmount=0,toBePaid=0,interest=0,billAmount=0;
	try {
		String valid=validData();
		if(valid.equals("valid")==true) {
			if(monthTransactions!=null&&monthTransactions.length>0) {
				for(int i=0;i<monthTransactions.length;i++) {
					if(monthTransactions[i].getTransactionType().equals("DB")==true) {
						dbTotalAmount+=monthTransactions[i].getTransactionAmount();
					}
					if(monthTransactions[i].getTransactionType().equals("CR")==true) {
						crTotalAmount+=monthTransactions[i].getTransactionAmount();
					}
				}
				
				toBePaid=Math.abs(crTotalAmount-dbTotalAmount);
				interest=(toBePaid*(0.199/12));  /*Interest calculated = (outstanding amount x 19.9% per year / 12)*/
				billAmount=toBePaid+interest;
			}
			else
				return 0.0;
		}
	} catch (InputInvalidException e) {
		return 0.0;
	}
	return billAmount;
}

}
