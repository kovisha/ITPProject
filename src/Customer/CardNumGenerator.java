package Customer;

import java.util.Random;

//class to generate customer id and loyalty card number
public class CardNumGenerator {
	
	//method to generate card number
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
	
	//method to generate ID
	public String idGenerator() {
			
			Random num = new Random();
			int numbers;
			String prefix = "CUS";
			
			for(int i = 0 ; i < 6 ; i++) {
				numbers = num.nextInt(10);
				prefix = prefix+numbers;
			}
	
			
			return prefix;
		}


}
