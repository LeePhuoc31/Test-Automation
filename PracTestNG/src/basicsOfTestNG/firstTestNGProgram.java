package basicsOfTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class firstTestNGProgram {
	@Test(priority=2)
	public void tc1() {
		Assert.assertEquals(12, 14);
		System.out.println("My first test");
	}

	@Test(priority=1)
	public void tc2() {
		System.out.println("My second test");
	}

	@Test(priority=3)
	public void tc3() {
		System.out.println("My thirst test");
	}
}
