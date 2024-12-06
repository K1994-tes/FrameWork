package Generic_Utilities;

import java.util.Random;

public class Java_Utility 
{
  /**this method is used to avoid duplicate values
	  * @author keerthi
	  * @return
	  */
	public int getRandomNum()
	{
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
		
	}
 
}
