package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.ExcelData;
import pages.RedBus_PF;

public class ExcelSheetData {
	WebDriver driver;
	@DataProvider(name="testdata")
	public Object getData() {
		ExcelData utils=new ExcelData("C:\\excelsheet\\CityNames.xlsx");
		int rows=utils.getRowCount(0);
		Object[][] MobileNo=new Object[rows][2];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<2;j++) {
				MobileNo[i][j]=utils.getdata(0,i+1, j);
				System.out.println(MobileNo[i][j]);
			}
		}
		return MobileNo;
	}
	@BeforeMethod public void before1() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver=new ChromeDriver(opt);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
	}
	@Test(dataProvider="testdata")
	public void pickup(String from,String to) throws InterruptedException {
		RedBus_PF obj=new RedBus_PF(driver);
		obj.bordingPoint(from);
		obj.destination(to);
		obj.date_pick();
		obj.search();
	}
}
