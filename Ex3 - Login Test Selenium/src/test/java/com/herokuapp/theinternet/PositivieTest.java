package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
@Test
public class PositivieTest {
	public void loginTest() {
		WebDriver driver=new ChromeDriver();
		String url="https://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.manage().window().maximize();	//div[@id='content']/div[1]/form[@name='loginform']/table//input[@name='uname']
		sleep(2);	
		WebElement username=driver.findElement(By.xpath("/html//input[@id='username']"));
		username.sendKeys("tomsmith");
		WebElement password=driver.findElement(By.xpath("/html//input[@id='password']"));
		password.sendKeys("SuperSecretPassword!");
		sleep(2);
		WebElement loginbtn=driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		loginbtn.click();	
		System.out.print("the test executed successfully");	
		driver.close();	
	}

	private void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}