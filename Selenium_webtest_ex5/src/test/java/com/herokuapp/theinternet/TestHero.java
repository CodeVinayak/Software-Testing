package com.herokuapp.theinternet;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestHero {

    @Test
    public void loginTest() throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();
        String url = "http://testphp.vulnweb.com/login.php";
        driver.get(url);
        driver.manage().window().maximize();
        sleep(2);

        WebElement username = driver.findElement(By.xpath("//div[@id='content']/div[1]/form[@name='loginform']/table//input[@name='uname']"));
        username.sendKeys("test");

        WebElement password = driver.findElement(By.xpath("//div[@id='content']/div[1]/form[@name='loginform']/table//input[@name='pass']"));
        password.sendKeys("test");
        sleep(2);

        WebElement loginbtn = driver.findElement(By.xpath("//div[@id='content']//form[@name='loginform']/table/tbody/tr[3]/td/input[@value='login']"));
        loginbtn.click();
        System.out.println("The Test Executed Successfully");

        
        String filePath = System.getProperty("user.dir") + File.separator + "userinfo.txt";
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line = reader.readLine();
        String[] content = line.split(",");

        WebElement field1_input = driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='urname']"));
        WebElement field2_input = driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='ucc']"));
        WebElement field3_input = driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='uemail']"));
        WebElement field4_input = driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//input[@name='uphone']"));
        WebElement field5_input = driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/table//textarea[@name='uaddress']"));
       
        // Clear the input fields
        field1_input.clear();
        field2_input.clear();
        field3_input.clear();
        field4_input.clear();
        field5_input.clear();
        
        field1_input.sendKeys(content[0]);
        field2_input.sendKeys(content[1]);
        field3_input.sendKeys(content[2]);
        field4_input.sendKeys(content[3]);
        field5_input.sendKeys(content[4]);
        sleep(5);
        WebElement submit_btn = driver.findElement(By.xpath("//div[@id='content']//form[@name='form1']/table/tbody/tr[6]/td/input[@name='update']"));
        submit_btn.click();
        reader.close();
        driver.close();
    }

    private void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
