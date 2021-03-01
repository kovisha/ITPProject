package Item;

import java.util.Random;

public class goodsIDGenerator {

public String categoryIDgenerator() {
		
		Random num = new Random();
		int numbers;
		String prefix = "CAT";
		
		for(int i = 0 ; i < 3 ; i++) {
			numbers = num.nextInt(10);
			prefix = prefix+numbers;
		}

		
		return prefix;
	}
	
public String itemIDgenerator() {
	
	Random num = new Random();
	int numbers;
	String prefix = "ITM";
	
	for(int i = 0 ; i < 3 ; i++) {
		numbers = num.nextInt(10);
		prefix = prefix+numbers;
	}

	
	return prefix;
}

public String stockIDgenerator() {
	
	Random num = new Random();
	int numbers;
	String prefix = "STK";
	
	for(int i = 0 ; i < 3 ; i++) {
		numbers = num.nextInt(10);
		prefix = prefix+numbers;
	}

	
	return prefix;
}

public String barcodeIdGenerator() {
	
	Random num = new Random();
	int numbers;
	
	String prefix = "BOO";
	
	for(int i = 0; i< 9;i++) {
		numbers = num.nextInt(10);
		prefix = prefix+numbers;
	}
	return prefix;
}
	
}
