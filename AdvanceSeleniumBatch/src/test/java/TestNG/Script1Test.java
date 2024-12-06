package TestNG;

import org.testng.annotations.Test;
@Test// if we give test annotation above class it executes all methods in class no need to give to each method
public class Script1Test 
{
@Test (invocationCount=3) // (priority=0)	
public void createProductTest()
{
	System.out.println("Product created");
}
@Test//(enabled=false)//(dependsOnMethods ="createProduct")  (priority=1)
public void modifyProductTest()
{
	System.out.println("Product modified");
}
@Test // (dependsOnMethods="createProduct") //(priority=-1)  //default priority (low priority executes 1st it accepts negative values also)
public void deleteProductTest()
{
	System.out.println("Product Deleted");
}
}
