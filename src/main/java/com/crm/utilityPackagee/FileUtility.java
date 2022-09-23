package com.crm.utilityPackagee;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
/**
 * to get the common data from property file
 * @param Key
 * @return
 * @throws IOException
 */

public String getPropertyValue(String Key) throws IOException 
{
	FileInputStream fileinputstream = new FileInputStream(IConstants.filepath);
	Properties properties = new Properties();
	properties.load(fileinputstream);
	String value = properties.getProperty(Key);
	return value;

	
	
}

}