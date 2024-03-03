Instructions
To Perform Web Testing using Selenium and perform following:
1. Searching URL
2. Logout Button
3. The Text Content
Aim: Perform Web Testing using Selenium
Procedure:
a. Open a web browser
b. Navigate to the specified URL
c. Search for a specific URL
d. Locate and click on the Logout button
Steps
1. Create a Project: Selenium_webtest_ex4
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
Now right click on same package com.herokuapp.theinternet and 
create new class. 
Enter name : PositiveTest The package and class will be created.
5.Add code to PostiviteTest.java 
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
sleep(2);
WebElement
username=driver.findElement(By.xpath("/html//input[@id='username']"));
username.sendKeys("tomsmith");
WebElement
password=driver.findElement(By.xpath("/html//input[@id='password']"));
password.sendKeys("SuperSecretPassword!");
sleep(2);
WebElement
loginbtn=driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fasign-in']"));
loginbtn.click();
//Search URL
String expectedurl="https://the-internet.herokuapp.com/secure";
String actualurl=driver.getCurrentUrl();
Assert.assertEquals(actualurl, expectedurl,"the URL not same as 
expected");
System.out.println("The program executed successfully");
//Search for logout
sleep(2);
WebElement
logoutbtn=driver.findElement(By.xpath("//div[@id='content']//a[@href='/logout']/i
[@class='icon-2x icon-signout']"));
Assert.assertTrue(logoutbtn.isDisplayed(),"Logout");
System.out.println("Logout Btn found");
//Search for content on the page does it matches;
String welcomemsg="You logged into a secure area!";
String
actual=driver.findElement(By.xpath("/html//div[@id='flash']")).getText();
Assert.assertTrue(actual.contains(welcomemsg),"Not found");
System.out.println("Welcome message matches");
System.out.print("Test Executed successfully");
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
6. Open cmd and go to file path
7. Run Code: mvn clean test