package page;

import java.util.Random;

public class BasePage {
	
	public static int randomNumGenerator() {
		Random rnd = new Random();
		int randomNum = rnd.nextInt(999);
		return randomNum;
		
	}

}
