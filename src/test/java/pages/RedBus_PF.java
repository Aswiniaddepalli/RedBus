package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedBus_PF {
	WebDriver driver;
		public RedBus_PF(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(id="src") WebElement from;
	    @FindBy(id="dest") WebElement to;
	    @FindBy(id="onwardCal") WebElement day;
	   // @FindBy(xpath="//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div[2]") WebElement nav;
	    @FindBy(xpath="//span[text()='7']") WebElement date_6;
	    @FindBy(xpath="//button[text()='SEARCH BUSES']") WebElement search;
	    public void bordingPoint(String string) {
	    	from.sendKeys(string);
	    	
	    }
	    public void destination(String string) throws InterruptedException {
	    	Thread.sleep(3000);
	    	to.sendKeys(string);
	    	 	
	    }
	    public void Day() {
	    	day.click();
	    }
//	    public void datenav() {
//	    	nav.click();
//	    }
	    public void date_pick() {
	    	date_6.click();
	    }
	    public void search() {
	    	search.click();
	    }
	    
}
