package utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Date {
	WebDriver driver;
	public void selectDate(String date)
	{
		System.out.println("Inside selectDate Method");
		System.out.println(date);
		WebElement datePicker = driver.findElement(By.xpath("//div[@id='onwardCal']/div[1]/div[2]/div[1]/div[1]/div[3]/div[3]/span[1]/div[5]/span[1]"));
		datePicker.click();
		List<WebElement> dates = datePicker.findElements(By.tagName("td"));
		System.out.println(dates.size());
		for(WebElement temp:dates)
		{
			if(temp.getText().equals(date))
			{
				System.out.println("Inside if to setdate");
				temp.click();
				break;
			}
		}
		//driver.findElement(By.id("search_button")).click();
	}
	

}
