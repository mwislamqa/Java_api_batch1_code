import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleAutomation {

	WebDriver driver;
	@Test
	public  void call() throws Exception {
		
		//webdriver is an interface we can't creat obj of that. we can initialize class only.
		//WebDriver driver= new WebDriver();
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		//driver.get("https://www.google.com/");
		 driver.get("http://demo.guru99.com/test/guru99home/");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 Thread.sleep(300);
		 js.executeScript("window.scrollBy(0,1000)");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		/*
		 * WebElement
		 * about=driver.findElement(By.xpath("/html/body/div[1]/div[1]/a[1]k"));
		 * if(about.getText().equalsIgnoreCase("about")) { System.out.println("pass");
		 * }else { System.out.println("fail"); }
		 */
		
		
		// Enter username
		
		

		WebElement web=	driver.findElement(By.name("q"));
		JavascriptExecutor jps = (JavascriptExecutor)driver;
		
		jps.executeScript("arguments[0].value='send something'", web);
		//web.sendKeys("selenium");
		

		//web.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='Selenium']")).click();

		
		  TakesScreenshot sc=(TakesScreenshot) driver; File src =
		  sc.getScreenshotAs(OutputType.FILE); File destFile = new
		  File(".\\Screenshots\\pic.png"); FileUtils.copyFile(src, destFile);
		 
		
		Thread.sleep(3000);
		//closing the webdriver
		driver.close();


	}

}
