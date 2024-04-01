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
//	    WebElement nav =driver.findElement(By.xpath("(//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div)[2]"));
//		nav.click();
	    @FindBy(xpath="//div[@class='DayNavigator__IconBlock-qj8jdz-2 iZpveD']/following-sibling::div)[2]") WebElement nav;
	    //WebElement  date_31 = driver.findElement(By.xpath("//span[text()='6']"));
	    @FindBy(xpath="//span[text()='6']") WebElement date_6;
	    public void bordingPoint(String string) {
	    	from.sendKeys(string);
	    	from.click();
	    }
	    public void destination(String string) {
	    	to.click();
	    	to.sendKeys(string);
	    	
	    	
	    }
	    public void datenav() {
	    	nav.click();
	    }
	    public void date_pick() {
	    	date_6.click();
	    }
	    
}
