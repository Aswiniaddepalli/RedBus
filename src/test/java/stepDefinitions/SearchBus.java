package stepDefinitions;
import java.awt.AWTException;
import pages.RedBus_PF;
import pages.Routes_PF;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.Date;
public class SearchBus {
	WebDriver driver;
	
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
		RedBus_PF obj=new RedBus_PF(driver);
		obj.bordingPoint("Hyderabad");
//		WebElement from=driver.findElement(By.id("src"));
//		from.sendKeys("Hyderabad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		//Thread.sleep(3000);
		//from.click();
//		 Robot robo=new Robot();
//	        robo.keyPress(KeyEvent.VK_ENTER);
//	        robo.keyRelease(KeyEvent.VK_ENTER);
		obj.destination("Vijayawada");
//WebElement dest1 = driver.findElement(By.id("dest"));
//dest1.sendKeys("Vijayawada");
//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
Thread.sleep(3000);
//dest1.click();
//robo.keyPress(KeyEvent.VK_ENTER);
//robo.keyRelease(KeyEvent.VK_ENTER);
	}
	@Then("I want to give the date")
	public void i_want_to_give_the_date()throws InterruptedException {
//		WebElement nav =driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div)[2]"));
//		nav.click();
		RedBus_PF obj=new RedBus_PF(driver);
		obj.Day();
		//obj.datenav();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
//        try {
//            Thread.sleep(2000);
//        }catch (Exception e){}
        obj.date_pick();
//        WebElement  date_31 = driver.findElement(By.xpath("//span[text()='6']"));
//        date_31.click();
//   	 WebElement  search_buses_button = driver.findElement(By.xpath("//button[text()='SEARCH BUSES']"));
//     search_buses_button.click();
        obj.search();
         
		}
	@Then("I want to get the different filters names")
	public void i_want_to_get_the_different_filters_names() {
        WebElement modify=driver.findElement(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
   	// WebElement modify=driver.findElement(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(modify));
       // driver.switchTo().frame(modify);
		//WebElement filter=driver.findElement(By.xpath("//div[@id='filter-block']/div/div[@class='title f-bold']"));
		List<WebElement> headings=driver.findElements(By.xpath("//div[@class='filter-titles f-12 f-bold']"));
		int noof=headings.size();
		//System.out.println("the first filter "+filter.getText()+"the no of heading of filters"+noof);
		for(WebElement heading: headings) {
			String names=heading.getText();
			System.out.println("The Filter Heading "+names);
		}
	}
	@When("I click on tsrtc buses")
	public void i_click_on_tsrtc_buses() {
//	     Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//		 WebElement modify=driver.findElement(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']"));
//	        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		 webDriverWait.until(ExpectedConditions.visibilityOf(modify));
//		 driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[4]/div[2]")).click();
		Routes_PF ob=new Routes_PF(driver);
		ob.tsrtcmethod();
	}

	@Then("I am able to see the list of buses")
	public void i_am_able_to_see_the_list_of_buses() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
//		 WebElement modify=driver.findElement(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']"));
//	        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		 webDriverWait.until(ExpectedConditions.visibilityOf(modify));
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0,document.body.scrollHeight)");		 
	}
	@When("I want to click on apsrtc buses")
	public void i_want_to_click_on_apsrtc_buses() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
//		 WebElement modify=driver.findElement(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']"));
//	        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		 webDriverWait.until(ExpectedConditions.visibilityOf(modify));
//		driver.findElement(By.xpath("(//div[text()='View Buses'])[2]")).click();
		Routes_PF ob=new Routes_PF(driver);
		ob.apsrtcmstod();
	}
	@When("I want click on filter")
	public void i_want_click_on_filter() {
	    // Write code here that turns the phrase above into concrete actions
//	    //throw new io.cucumber.java.PendingException();
//		WebElement modify=driver.findElement(By.xpath("//div[@class='onward-modify-btn g-button clearfix fl']"));
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	 webDriverWait.until(ExpectedConditions.visibilityOf(modify));
//		driver.findElement(By.xpath("//div[@id='filter-block']/div/div[2]/ul[2]/li/label[@class='custom-checkbox' and @for='dtBefore 6 am']")).click();
		Routes_PF ob=new Routes_PF(driver);
		ob.checkBox();
		
	}

	@Then("It gives available buses")
	public void it_gives_available_buses() {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
//		JavascriptExecutor javascript=(JavascriptExecutor) driver;
//		javascript.executeScript("window.scrollBy(0,200)");
		String Expected="https://www.redbus.in/bus-tickets/hyderabad-to-vijayawada?fromCityName=Hyderabad&fromCityId=124&srcCountry=IND&toCityName=Vijayawada&toCityId=134&destCountry=IND&onward=7-Apr-2024&opId=0&busType=Any";
		String actual=driver.getCurrentUrl();
		System.out.println(actual);
		Assert.assertEquals(actual, Expected);
	}
	}