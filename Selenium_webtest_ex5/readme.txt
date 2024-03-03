Instructions 
Website: http://testphp.vulnweb.com/userinfo.php
To Perform Web Testing using Selenium and perform following: 
1. Login the website 
2.Enter text document to notepad 
3.Update text content to website
Aim: Perform Web Testing using Selenium 
Procedure: 
a. Open a web browser and Login 
b. Retrieve and manipulate text content on the webpage
Steps
1. Created a Project: Selenium_webtest_ex5
2. In pom.xml change http to https 
3. Add dependency and plugins in pom.xml
<project xmlns="https://maven.apache.org/POM/4.0.0"
xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
https://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>
<groupId>com.herokuapp.the-internet</groupId>
<artifactId>Selenium_webtest</artifactId>
<version>0.0.1-SNAPSHOT</version>
<name>selenium exp3</name>
<dependencies>
<dependency>
<groupId>org.testng</groupId>
<artifactId>testng</artifactId>
<version>7.9.0</version>
<scope>test</scope>
</dependency>
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>4.17.0</version>
</dependency>
</dependencies>
<build>
<plugins>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.12.1</version>
<configuration>
<source>21</source>
<target>21</target>
</configuration>
</plugin>
<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-surefire-plugin</artifactId>
<version>3.2.5</version>
</plugin>
</plugins>
</build>
</project>
4. Right click on src/test/java 
Create new package Name : com.herokuapp.theinternet 
Now right click on same package com.herokuapp.theinternet and create new class.
Enter name : TestHero The package and class will be created. 
5.Add code to TestHero.java
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
 WebElement username =
driver.findElement(By.xpath("//div[@id='content']/div[1]/form[@name='loginfor
m']/table//input[@name='uname']"));
 username.sendKeys("test");
 WebElement password =
driver.findElement(By.xpath("//div[@id='content']/div[1]/form[@name='loginfor
m']/table//input[@name='pass']"));
 password.sendKeys("test");
 sleep(2);
 WebElement loginbtn =
driver.findElement(By.xpath("//div[@id='content']//form[@name='loginform']/ta
ble/tbody/tr[3]/td/input[@value='login']"));
 loginbtn.click();
 System.out.println("The Test Executed Successfully");
 
 String filePath = System.getProperty("user.dir") + File.separator +
"userdetail.txt";
 BufferedReader reader = new BufferedReader(new FileReader(filePath));
// BufferedReader reader = new BufferedReader(new 
FileReader(filePath));
 String line = reader.readLine();
 String[] content = line.split(",");
 WebElement field1_input =
driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/
table//input[@name='urname']"));
 WebElement field2_input =
driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/
table//input[@name='ucc']"));
 WebElement field3_input =
driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/
table//input[@name='uemail']"));
 WebElement field4_input =
driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/
table//input[@name='uphone']"));
 WebElement field5_input =
driver.findElement(By.xpath("//div[@id='content']/div[2]/form[@name='form1']/
table//textarea[@name='uaddress']"));
 
 // Clear the input fields
 field1_input.clear();
 field2_input.clear();
 field3_input.clear();
 field4_input.clear();
 field5_input.clear();
// sleep(5);
 field1_input.sendKeys(content[0]);
 field2_input.sendKeys(content[1]);
 field3_input.sendKeys(content[2]);
 field4_input.sendKeys(content[3]);
 field5_input.sendKeys(content[4]);
 sleep(5);
 WebElement submit_btn =
driver.findElement(By.xpath("//div[@id='content']//form[@name='form1']/table/
tbody/tr[6]/td/input[@name='update']"));
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
6. Open cmd and go to file path
7. Run Code: mvn clean test