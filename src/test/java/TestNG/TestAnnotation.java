package TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotation {

	@BeforeSuite
	public void f1()
	{
		System.out.println("before suite");
	}
	@BeforeTest
	public void f11()
	{
		System.out.println("before teswt");
	}
	@BeforeClass
	public void f111()
	{
		System.out.println("before class");
	} 
	@BeforeMethod
	public void f1111()
	{
		System.out.println("before method");
	}
	@Test
	public void function1()
	{
		System.out.println("test..........");
	}
	@AfterSuite
	public void ff1()
	{
		System.out.println("after suite");
	}
	@AfterTest
	public void ff11()
	{
		System.out.println("after test");
	}
	@AfterClass
	public void ff111()
	{
		System.out.println("asfter class");
	}
	@AfterMethod
	public void ff1111()
	{
		System.out.println("after methodi");
	}
}
