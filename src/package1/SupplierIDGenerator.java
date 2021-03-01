package package1;

import java.util.Random;

public class SupplierIDGenerator {
	
	/*Generating Random ID For The Supplier*/
	public String supplierIDgenerator() {
		
		Random num = new Random();
		int numbers;
		String prefix = "SUP";
		
		for(int i = 0; i < 6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
		
		return prefix;
	}
	
	/*Generating Random ID For The Supplier Payment*/
	public String supplierpaymentIDgenerator() {
		
		Random num = new Random();
		int numbers;
		String prefix = "SPY";
		
		for(int i = 0; i < 6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
		
		return prefix;
	}
	
	/*Generating Random ID For The Supplier Discount*/
	public String supplierdiscountIDgenerator() {
		
		Random num = new Random();
		int numbers;
		String prefix = "SUD";
		
		for(int i = 0; i < 6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
		
		return prefix;
	}

}
