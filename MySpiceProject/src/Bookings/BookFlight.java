package Bookings;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookFlight {
	@BeforeMethod
	public void BeforeMethodTestcase1() {
		System.out.println("This code will be run before every testcase");
	}

	@Test
	public void BookFlight_RoundTrip_TestCase1() {
		System.out.println("TestCase1");
	}

	@Test(dependsOnMethods = { "BookFlight_RoundTrip_TestCase1" })
	public void BookFlight_RoundTrip_TestCase2() {
		System.out.println("TestCase2");
	}

	@BeforeTest
	public void Beforetesttestcases() {
		System.out.println("This should be first");
	}

	@AfterTest
	public void Aftertesttestcase1() {
		System.out.println("This should be last");
	}

	@Test
	public void BookFlight_RoundTrip_TestCase3() {
		System.out.println("TestCase3");
	}

	@Test(enabled = false)
	public void BookFlight_RoundTrip_TestCase4() {
		System.out.println("TestCase4");
	}
}
