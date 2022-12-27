//DDTExcel.java
package exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTExcel {

	// TODO Auto-generated method stub

	WebDriver driver;

	protected static String result;

	@Test(dataProvider = "testdata")
	public void DemoProject(String username, String password) {

		try {
			System.setProperty("webdriver.chrome.driver",
					"D:\\DBCL&KTPM_Nhom2\\Install Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			// driver.get("http://newtours.demoaut.com/");
			driver.get("https://elearning.ctu.edu.vn/login/index.php");

			// driver.findElement(By.name("username")).sendKeys(username);
			// driver.findElement(By.name("password")).sendKeys(password);

			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);

			// driver.findElement(By.name("login")).click();

			driver.findElement(By.id("loginbtn")).click();

			Thread.sleep(5000);

			// Assert.assertTrue(driver.getTitle().matches("Find a Fligh: Mercury Tours:"),
			// "Invalid credentials");
			// System.out.println("Login successful");

			result = driver.findElement(
					By.xpath("//*[@id='frontpage-category-names']/h2")).getText();
			

			System.out.println(result);
			Assert.assertEquals(result, "Danh mục khoá học");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	void ProgramTermination() {
		driver.quit();
	}

	@DataProvider(name = "testdata")
	public Object[][] TestDataFeed() {
		// New.ReadExcelFile config = new
		// New.ReadExcelFile("C:\\Users\\Vardhan\\workspace\\Selenium\\LoginCreadentials.xlsx");
		New.ReadExcelFile config = new New.ReadExcelFile(
				"D:\\DBCL&KTPM_Nhom2\\TestProject\\LoginElearning.xlsx");

		int rows = config.getRowCount(0);

		Object[][] credentials = new Object[rows][2];

		for (int i = 0; i < rows; i++) {
			credentials[i][0] = config.getData(0, i, 0);
			credentials[i][1] = config.getData(0, i, 1);

		}

		return credentials;
	}

}
