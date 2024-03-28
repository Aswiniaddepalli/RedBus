package stepDefinitions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Date;
public class SearchBus {
	WebDriver driver;
	List<String> monthList = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec");
	String expDate = null;
	int expMonth;
	int expYear;
	String calDate = null;
	int calMonth;
	int calYear;
	boolean dateNotFound;
	
	@Given("I am on the Red Bus application")
	public void i_am_on_the_red_bus_application() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver=new ChromeDriver(opt);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
	}

	@When("I want to give  two cities names")
	public void i_want_to_give_two_cities_names() throws AWTException, InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
		
		WebElement from=driver.findElement(By.id("src"));
				from.sendKeys("Hyderabad");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				//Thread.sleep(3000);
				from.click();
				 Robot robo=new Robot();
			        robo.keyPress(KeyEvent.VK_ENTER);
			        robo.keyRelease(KeyEvent.VK_ENTER);
				//from.click();
		//driver.findElement(By.xpath("//div[@id='autoSuggestContainer']/div/div/div/div/ul/li[1]/div/text")).click();
		//driver.findElement(By.xpath("//div[@id='autoSuggestContainer']/div/div/div/div/ul/li[1]")).click();		
		WebElement dest1 = driver.findElement(By.id("dest"));
		dest1.sendKeys("Vijayawada");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Thread.sleep(3000);
		dest1.click();
		robo.keyPress(KeyEvent.VK_ENTER);
        robo.keyRelease(KeyEvent.VK_ENTER);
	}
	@Then("I want to give the date")
	public void i_want_to_give_the_date()throws InterruptedException {
		
		 WebElement calendar = driver.findElement(By.xpath("//span[text()='Date']"));
		    calendar.click();
		    expDate="14";
		    expMonth = 5;
		    expYear = 2024;
			dateNotFound = true;
			
			while(dateNotFound)
			{
				WebElement monthYearEle = driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD'])[2]"));
				String monthYear= monthYearEle.getAttribute("innerHTML");
				System.out.println(monthYear);
				String[] s = monthYear.split(" ");
				String calMonth = s[0];
				String[] tempYear = s[1].split("<");
				int calYear=Integer.parseInt(tempYear[0]);
				System.out.println(calMonth);
				System.out.println(calYear);
				
				if(monthList.indexOf(calMonth)+1 == expMonth && expYear == calYear)
				{
					System.out.println("Inside If to call selectDate method");
					Date obj=new Date(driver);
					obj.selectDate(expDate);
					dateNotFound=false;
				}   
				else if(monthList.indexOf(calMonth)+1 < expMonth && expYear==calYear || expYear>calYear)
				{
					calendar.findElement(By.xpath("//div[@class='DayNavigator__CalendarHeader-qj8jdz-1 fxvMrr']//div[3]//*[name()='svg']")).click();
				}
				else if(monthList.indexOf(calMonth)+1 > expMonth && expYear==calYear||expYear<calYear)
				{
					calendar.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']//button[.='<']")).click();
				}
			}
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.xpath("//button[@class='sc-dxgOiQ iztAdt']"));
		driver.switchTo().frame(search);
		search.click();
		}
	}