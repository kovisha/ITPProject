package userPayment;

import java.util.Random;

public class receiptNoGenerator {
	
	public String receiptNoGenerator() {
		
		Random num = new Random();
		int numbers;
		String prefix= "REC";
			
		for(int i=1; i<=6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
			
		return prefix;
	}

}
