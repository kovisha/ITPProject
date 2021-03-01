package Installment;

import java.util.Random;

public class installmentTypeIdGenerator {
	
	public String installmentTypeIdGenerator() {
			
		Random num = new Random();
		int numbers;
		String prefix= "ITY";
			
		for(int i=1; i<=6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
			
		return prefix;
	}

}
