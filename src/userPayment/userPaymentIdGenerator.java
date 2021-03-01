package userPayment;

import java.util.Random;

public class userPaymentIdGenerator {
	
	public String userPaymentIdGenerator() {
		
		Random num = new Random();
		int numbers;
		String prefix= "UPY";
			
		for(int i=1; i<=6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
			
		return prefix;
	}

}
