package model;

import java.util.Random;

public class CardNumGenerator {
	
	public String generator() {
		
		Random num = new Random();
		int numbers;
		String prefix = "UDS";
		
		for(int i = 0 ; i < 7 ; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}

		
		return prefix;
	}
	
	
	public String idGenerator() {
			
			Random num = new Random();
			int numbers;
			String prefix = "CUS";
			
			for(int i = 0 ; i < 3 ; i++) {
				numbers = num.nextInt(10);
				prefix = prefix+numbers;
			}
	
			
			return prefix;
		}

}
