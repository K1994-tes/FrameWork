package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx 
{
@Test (enabled=false)
public void m1()
{
	System.out.println("Step1");
	System.out.println("Step2");
    Assert.assertEquals(true, false);
	System.out.println("Step3");
	System.out.println("Step4");
}
@Test(enabled = false)
public void m2()
{
	String expData="qspiders";
	String actData="qspiders";
	Assert.assertEquals(actData, expData);
	
}
@Test(enabled = false)
public void m3()
{
	int a=10;
	int b=10;
	Assert.assertEquals(a, b, "Not Equal =");
	System.out.println("it is equal");
}
@Test(enabled=false)
public void m4()
{
	int a=10;
	int b=10;
	Assert.assertNotEquals(a, b, "It is Equal");
	System.out.println("it is not equal");
}
@Test
public void m5()
{
	String s1 ="Rahu";
	String s2="Rahul";
	Assert.assertTrue(s1.equalsIgnoreCase(s2), "False=");
	System.out.println("True==");
}
@Test
public void m6()
{
	String s1 ="Rahul";
	String s2="Rahul";
	Assert.assertFalse(s1.equalsIgnoreCase(s2), "Equal==");
	System.out.println("data is not equal");
}
@Test
public void m7()
{
	String s=null;
	Assert.assertNull(s, "it is not Null");
	System.out.println("it is null");
}
@Test
public void m8()
{
	String s="hello";
	Assert.assertNull(s, "it is not Null");
	System.out.println("it is null");
}
@Test
public void m9()
{
	String s="hello";
	Assert.assertNotNull(s, "it is not Null");
	System.out.println("it is null");
}
@Test
public void m10()
{
	String s="hell";
	String s1="hello";
	Assert.assertSame(s, s1,"same");
	System.out.println("it is not same");
}
@Test
public void m11()
{
	String s="hell";
	String s1="hello";
	Assert.assertSame(s, s1,"same");
	System.out.println("it is not same");
}


}
