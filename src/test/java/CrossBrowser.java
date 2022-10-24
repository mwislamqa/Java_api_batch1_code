import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowser {
	WebDriver driver;
	@Parameters("Browser")
	@Test
	public  void setup(String browser) {
		 
	
	if(browser.equalsIgnoreCase("Chrome")){
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
	}
	else if(browser.equalsIgnoreCase("Firefox")){
		WebDriverManager.firefoxdriver().setup();
		 driver= new FirefoxDriver();
	}
		
		  driver.get("https://www.google.com/"); WebElement
		  about=driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]"));
		  if(about.getText().equalsIgnoreCase("about")) { System.out.println("pass");
		  }else { System.out.println("fail"); }
		  
		  WebElement web= driver.findElement(By.xpath(
		  "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
		  web.sendKeys("selenium");
		 
	}
}