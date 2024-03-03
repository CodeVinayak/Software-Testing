package com.herokuapp.theinternet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
@Test
public class PositiveTest {
	public void loginTest() {
		WebDriver driver=new ChromeDriver();
		String url="https://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.manage().window().maximize();
		
		sleep(5);
		
		WebElement username=driver.findElement(By.xpath("/html//input[@id='username']"));
		username.sendKeys("tomsmith");
		WebElement password=driver.findElement(By.xpath("/html//input[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		sleep(5);
		WebElement loginbtn=driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		loginbtn.click();
		
		//Search URL
		String expectedurl="https://the-internet.herokuapp.com/secure";
		String actualurl=driver.getCurrentUrl();
		
		Assert.assertEquals(actualurl,  expectedurl,"the URL not same as expected");
		System.out.println("The program executed successfully");
		
		//Search for logout
		sleep(5);
		WebElement logoutbtn=driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i[@class='icon-2x icon-signout']"));
		
		Assert.assertTrue(logoutbtn.isDisplayed(),"Logout");
		
		System.out.println("Logout Btn found");
		
		//Search for content on the page does it matches;
		String welcomemsg="You logged into a secure area!";
		String actual=driver.findElement(By.xpath("/html//div[@id='flash']")).getText();
		Assert.assertTrue(actual.contains(welcomemsg),"Not found");
		System.out.println("Welcome message matches");
		System.out.print("Test Executed successfully");
		driver.close();
	}

	private void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
