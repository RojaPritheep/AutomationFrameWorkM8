package genericUtilities;

import java.util.Date;
/**
* This Class consists of generic method related to java
*  @author Roja
*
*/

public class JavaUtility {
	/**
	 * this method will capture the current system date in required format
	 * @return
	 */
	
	public String getSystemDate()
	{
		Date d=new Date();
		String[] dArr =d.toString().split(" ");
		String date =dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
        return date;
		
	}

}
  