package unit_tesing;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import thuvien.tinhtoan.PhepTinh;

public class TestPhepToan {
	@BeforeMethod
	public void Bf() {
		System.out.println("Before testcase");
	}

	@AfterMethod
	public void Af() {
		System.out.println("After testcase");
	}

	@Test(dataProvider = "testdata+")
	public void TestCong(float x, float y, float expected) {
		float actual = (PhepTinh.Op('+', x, y));
		Assert.assertEquals(actual, expected, "Sai");
		System.out.println("Testcase +");
	}

	@Test(dataProvider = "testdata-")
	public void TestTru(float x, float y, float expected) {
		float actual = (PhepTinh.Op('-', x, y));
		Assert.assertEquals(actual, expected, "Sai");
		System.out.println("Testcase -");
	}

	@Test(dataProvider = "testdata*")
	public void TestNhan(float x, float y, float expected) {
		float actual = (PhepTinh.Op('*', x, y));
		Assert.assertEquals(actual, expected, "Sai");
		System.out.println("Testcase *");
	}

	@DataProvider(name = "testdata+")
	public Object[][] TestDataFeed0() {
		ReadExcelFile config = new ReadExcelFile(
				"D:\\Study\\CT243\\DBCL_KTPM_Nhom2\\Install Selenium\\BaiTapKiemThu\\TestData.xlsx");

		int rows = config.getRowCount(0);

		Object[][] data = new Object[rows][3];

		for (int i = 0; i < rows; i++) {
			data[i][0] = (float) config.getDataNum(0, i, 0); 
			data[i][1] = (float) config.getDataNum(0, i, 1);
			data[i][2] = (float) config.getDataNum(0, i, 2);
		}

		return data;
	}

	@DataProvider(name = "testdata-")
	public Object[][] TestDataFeed1() {
		ReadExcelFile config = new ReadExcelFile(
				"D:\\Study\\CT243\\DBCL_KTPM_Nhom2\\Install Selenium\\BaiTapKiemThu\\TestData.xlsx");

		int rows = config.getRowCount(1);

		Object[][] data = new Object[rows][3];

		for (int i = 0; i < rows; i++) {
			data[i][0] = (float) config.getDataNum(1, i, 0);
			data[i][1] = (float) config.getDataNum(1, i, 1);
			data[i][2] = (float) config.getDataNum(1, i, 2);
		}

		return data;
	}

	@DataProvider(name = "testdata*")
	public Object[][] TestDataFeed2() {
		ReadExcelFile config = new ReadExcelFile(
				"D:\\Study\\CT243\\DBCL_KTPM_Nhom2\\Install Selenium\\BaiTapKiemThu\\TestData.xlsx");

		int rows = config.getRowCount(2);

		Object[][] data = new Object[rows][3];

		for (int i = 0; i < rows; i++) {
			data[i][0] = (float) config.getDataNum(2, i, 0);
			data[i][1] = (float) config.getDataNum(2, i, 1);
			data[i][2] = (float) config.getDataNum(2, i, 2);
		}

		return data;
	}
}
