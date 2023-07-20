package practice_bbg;

import java.io.IOException;
import java.util.Random;

public class createRN {
	
	public createRN() {
		
	}
	
	public int[] returnRN() {
		int[] rn = new int[3];
		Random random = new Random();
		random.setSeed(System.currentTimeMillis());
		
		rn[0] = random.nextInt(8) + 1;
		rn[1] = random.nextInt(8) + 1;
		rn[2] = random.nextInt(8) + 1;
		return rn;
	}

}
