package Generic_Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class File_Utility 
{
/**
 * this method is used to read data from properties_file(External Resource)
 * @param Key
 * @return 
 * @author Keerthi
 * @throws Throwable
 */
	public String getKeyAndValuePair(String Key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(Key);
		return value;
	}
}
