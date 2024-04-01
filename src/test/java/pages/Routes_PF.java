package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Routes_PF {
	WebDriver driver;
	public Routes_PF(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='onward-modify-btn g-button clearfix fl']") WebElement mod;
	@FindBy(xpath="//div[@id='root']/div/div[2]/div/div[2]/div[2]/div[1]/div/div[2]/div/div[4]/div[2]") WebElement tsrtc;
	
	public void tsrtcmethod() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 webDriverWait.until(ExpectedConditions.visibilityOf(mod));
		 tsrtc.click();
	}
	@FindBy(xpath="(//div[text()='View Buses'])[2]") WebElement apsrtc;
	public void apsrtcmstod() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 webDriverWait.until(ExpectedConditions.visibilityOf(mod));
		 apsrtc.click();
	}
	@FindBy(xpath="//div[@id='filter-block']/div/div[2]/ul[2]/li/label[@class='custom-checkbox' and @for='dtBefore 6 am']") WebElement check;
	public void checkBox() {
		WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 webDriverWait.until(ExpectedConditions.visibilityOf(mod));
		 check.click();
	}
}
