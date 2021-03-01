package Offer;

import java.util.Random;

public class offerIdGenerator {
	
	public String offerIdGenerator() {
			
		Random num = new Random();
		int numbers;
		String prefix= "OFF";
			
		for(int i=1; i<=6; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}
			
		return prefix;
	}

}
