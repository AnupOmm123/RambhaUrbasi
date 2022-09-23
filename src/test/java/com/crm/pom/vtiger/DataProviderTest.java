package com.crm.pom.vtiger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
	
	@Test(dataProvider ="add")
	public void amazon(String name , String price)
		{
			System.out.println("product name = "+name+"product price ="+price);
		}
		
		@DataProvider
		public Object[][] add()
		{
			Object[][] objArr=new Object[2][2];
			objArr[0][0]="apple12";
			objArr[0][1]="50000";
			
			objArr[1][0]="vivoU20";
			objArr[1][1]="15000";
			return objArr;
		}
			
}
