import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiWindows {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		//driver.get("https://www.google.com/");
		 driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		 driver.findElement(By.id("newWindowBtn")).click();
		 String parentwind = driver.getWindowHandle();
			System.out.println("parent window:::::::::::::" + parentwind);

			for (String childwindow : driver.getWindowHandles()) {
				System.out.println("child window property::::" + childwindow);
				// switch to focus child window
				driver.switchTo().window(childwindow);
			}
			
			
		String chTitle=	driver.getTitle();
		System.out.println(chTitle);
		
		driver.findElement(By.xpath("//li[@class='hub-home']/a")).click();
		/*
		 * if(chTitle == "H Y R Tutorials - Atom") { System.out.println("pass"); } else {
		 * System.out.println("fail"); }
		 */

		driver.close();
		driver.switchTo().window(parentwind);
		
		String paTitle1=	driver.getTitle();
		System.out.println(paTitle1);
		
		if(paTitle1.contains("Window Handles Practice - H Y R Tutorials")) 
		{ System.out.println("pass"); } 
		else 
		{
			 System.out.println("fail");
			 
	}
		WebElement tit=driver.findElement(By.xpath("(//*[contains(text(),'Window Handles Practice')])[2]"));
		if(tit.getText().contains("Window Handles Practice")) {
			System.out.println(" parent tit pass");
		}else {
			System.out.println("parent tit fail");
		}
		//driver.findElement(By.id("newWindowBtn")).click();
		Thread.sleep(4000);
		driver.quit();
	}
}
