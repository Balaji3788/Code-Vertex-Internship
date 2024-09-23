package CurrencyConverter_java;

import java.util.Scanner;

public class Currency_converter{
	public static void print_detail() {
		System.out.println(" 1. INR to DOLLAR \n 2. INR to EURO \n 3. INR to Swiss France \n 4. INR to Pund Sterling \n 5. INR to Gibraltar Pound ");
	}
	
	
	public static void main(String[] args) {
		float takeNumber;
		float result;
		System.out.println("\n Welcome to Currency Converter");
		print_detail();
		System.out.println("Select Any One of Them:");
		Scanner sc = new Scanner (System.in);
		int takeInput;
		takeInput = sc.nextInt();
		switch (takeInput) {
			case 1:
				System.out.println("Enter Rupees to Convert INR to DOLLAR");
				takeNumber = sc.nextFloat();
				result = (float)(takeNumber * 0.011);
				System.out.printf("%.2f INR is equal to %.2f DOLLAR %n",takeNumber,result);
				break;
				
			case 2:
				System.out.println("Enter Rupees to Convert INR to Euro");
				takeNumber = sc.nextFloat();
				result = (float)(takeNumber * 0.011);
				System.out.printf("%.2f INR is equal to %.2f Euro %n",takeNumber,result);
				break;
				
			case 3:
				System.out.println("Enter Rupees to Convert INR to Swiss France");
				takeNumber = sc.nextFloat();
				result = (float)(takeNumber * 0.010);
				System.out.printf("%.2f INR is equal to %.2f Swiss France %n",takeNumber,result);
				break;
				
			case 4:
				System.out.println("Enter Rupees to Convert INR to Pound Sterling ");
				takeNumber = sc.nextFloat();
				result = (float)(takeNumber * 0.0095);
				System.out.printf("%.2f INR is equal to %.2f Pound Sterling %n",takeNumber,result);
				break;

			case 5:
				System.out.println("Enter Rupees to Convert INR to Gibraltar Pounds");
				takeNumber = sc.nextFloat();
				result = (float)(takeNumber * 0.011);
				System.out.printf("%.2f INR is equal to %.2f Gibratar Pounds %n",takeNumber,result);
				break;
		default:
			System.out.println("Opps something went wrong May be You can Entered Invalid Input");
			break;

		}
		
	}
}