package com.crm.pom.vtiger;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.utilityPackagee.ExcelUtility;

public class DatProviderFromExcel {
	ExcelUtility elib = new ExcelUtility();
@Test(dataProvider = "add")
public void amazon(String name, String price)
{
	System.out.println("product name= "+name+"product price"+price);
}
@DataProvider
public Object[][] add() throws EncryptedDocumentException, FileNotFoundException, IOException
{

String mobile1 = elib.getDataFromExcel("DataProvider", 1, 1);
String price1 = elib.getDataFromExcel("DataProvider", 1, 2);
String mobile2 = elib.getDataFromExcel("DataProvider", 2,1);
String price2 = elib.getDataFromExcel("DataProvider", 2,2);

Object[][] objArr=new Object[2][2];
objArr[0][0]=mobile1;
objArr[0][1]=price1.toString();
objArr[1][0]=mobile2;
objArr[1][1]=price2.toString();

return objArr;
}

}
