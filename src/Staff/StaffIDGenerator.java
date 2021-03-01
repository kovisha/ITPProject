package Staff;
import java.util.Random;

public class StaffIDGenerator {
	
	  public String staffIDgenerator() {
	        
	        Random num = new Random();		//Creating a random number object
	        int numbers;					
	        String prefix = "STF";			//prefix to the staff 
	        
	        for(int i = 0; i < 6; i++) {	//For loop to iterate 
	            numbers = num.nextInt(10);	//random numbers picked and assigned the varibales wwithn 1 and 0
	            prefix = prefix+numbers;	//Concatanating both prefix and numbers
	        }
	        
	        return prefix;					//return the prefix

}
	  
	  
}
