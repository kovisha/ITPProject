package Order_Management;

import java.util.Random;

public class OrderIdGenerator {
	
	public String OrderIDgenerator() {
	       
        Random num = new Random();
        int numbers;
        String prefix = "ODD";
       
        for(int i = 0; i < 6; i++) {
            numbers = num.nextInt(10);
            prefix = prefix+numbers;
        }
       
        return prefix;
    }
	
}
