package com.wipro.ccbill.main;

import java.text.SimpleDateFormat;

import com.wipro.ccbill.entity.CreditCardBill;
import com.wipro.ccbill.entity.Transaction;

public class MainClass {
public static void main(String args[]) {
	try{
	      Transaction monthsTransaction[] = new Transaction[5];
	      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	     
	      monthsTransaction[0]=new Transaction("1111222233334444",formatter.parse("01/02/2016"),"household",8000.0,"DB");
	      monthsTransaction[1]=new Transaction("1111222233334444",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");
	      monthsTransaction[2]=new Transaction("1111222233334444",formatter.parse("12/02/2016"),"movie",2700.0,"DB");
	      monthsTransaction[3]=new Transaction("1111222233334444",formatter.parse("16/02/2016"),"paid",19000.0,"CR");
	      monthsTransaction[4]=new Transaction("1111222233334444",formatter.parse("19/02/2016"),"household",4500.0,"DB");
	      
	      
	      CreditCardBill ccbill = new CreditCardBill("1111222233334444","ABC123",formatter.parse("02/03/2016"),monthsTransaction);
	      System.out.println("Total to be paid : "+ccbill.calculateBillAmount());
	      
	     
	      Transaction monthsTransaction1[] = new Transaction[0];
	      
	      CreditCardBill ccbill1 = new CreditCardBill("1111222233334444","ABC12",formatter.parse("02/03/2016"),monthsTransaction1);
	      System.out.println("Total to be paid : "+ccbill1.calculateBillAmount());
	      
	      CreditCardBill ccbill2 = new CreditCardBill("11112222333344","ABC12",formatter.parse("02/03/2016"),monthsTransaction1);
	      System.out.println("Total to be paid : "+ccbill2.calculateBillAmount());
	      
	      CreditCardBill ccbill3 = new CreditCardBill("1111222233334411","ABC123",formatter.parse("02/03/2016"),monthsTransaction1);
	      System.out.println("Total to be paid : "+ccbill3.calculateBillAmount());
	      
	      CreditCardBill ccbill4 = new CreditCardBill("1111222233334411","ABC123",formatter.parse("02/03/2016"),null);
	      System.out.println("Total to be paid : "+ccbill4.calculateBillAmount());
	      
	      CreditCardBill ccbill5 = new CreditCardBill(null,"ABC123",formatter.parse("02/03/2016"),monthsTransaction);
	      System.out.println("Total to be paid : "+ccbill5.calculateBillAmount());
	      
	      CreditCardBill ccbill6 = new CreditCardBill("1111111111111111",null,formatter.parse("02/03/2016"),monthsTransaction);
	      System.out.println("Total to be paid : "+ccbill6.calculateBillAmount());
	      
	      CreditCardBill ccbill7 = new CreditCardBill("1111111111111111","452545454",formatter.parse("02/03/2016"),monthsTransaction);
	      System.out.println("Total to be paid : "+ccbill7.calculateBillAmount());
	      
	      
	      Transaction monthsTransaction2[] = new Transaction[9];
	     
	      monthsTransaction2[0]=new Transaction("2222333344441111",formatter.parse("01/02/2016"),"household",8000.0,"DB");
	      monthsTransaction2[1]=new Transaction("2222333344441111",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");
	      monthsTransaction2[2]=new Transaction("2222333344441111",formatter.parse("12/02/2016"),"movie",2700.0,"DB");
	      monthsTransaction2[3]=new Transaction("2222333344441111",formatter.parse("16/02/2016"),"paid",19000.0,"CR");
	      monthsTransaction2[4]=new Transaction("2222333344441111",formatter.parse("19/02/2016"),"household",4500.0,"DB");
	      monthsTransaction2[5]=new Transaction("2222333344441111",formatter.parse("01/02/2016"),"household",8000.0,"DB");
	      monthsTransaction2[6]=new Transaction("2222333344441111",formatter.parse("05/02/2016"),"Textile",12000.0,"DB");
	      monthsTransaction2[7]=new Transaction("2222333344441111",formatter.parse("12/02/2016"),"movie",2700.0,"DB");
	      monthsTransaction2[8]=new Transaction("2222333344441111",formatter.parse("16/02/2016"),"paid",19000.0,"CR");
	      
	      CreditCardBill ccbill8 = new CreditCardBill("2222333344441111","ABC123",formatter.parse("02/03/2016"),monthsTransaction2);
	      System.out.println("Total to be paid : "+ccbill8.calculateBillAmount());
	      
	      
	      
	      
	      
	      }catch(Exception e){
	    	  System.out.println(e);
	      }
}
}
