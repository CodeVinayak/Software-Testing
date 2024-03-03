Ex3.
AIM: To check login functionality of website (https://the-internet.herokuapp.com/login).
Procedure:
Step 1: To check if java and maven is installed.
Step 2: Open Eclipse IDE.
Create a folder and open a maven project.
Step3: In this experiment we are going to test the website:
https://the-internet.herokuapp.com/login
so we will use group id as:
com.herokuapp.theinternet
Enter artifact as Selenium_webtest
Enter name as selenium experiment number.
Step4: open pom.xml replace http with htpps
Step 5: Install 
1.compiler
https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html
Code:
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
 </plugins>
 </build>
2.Surfire plugin
https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html
copy code of Using Suite XML Files
 <plugin>
 <groupId>org.apache.maven.plugins</groupId>
 <artifactId>maven-surefire-plugin</artifactId>
 <version>3.2.5</version>
 <configuration>
 <suiteXmlFiles>
 <suiteXmlFile>testng.xml</suiteXmlFile>
 </suiteXmlFiles>
 </configuration>
 </plugin>
3.Testing dependency
https://mvnrepository.com/artifact/org.testng/testng/7.9.0
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
 <groupId>org.testng</groupId>
 <artifactId>testng</artifactId>
 <version>7.9.0</version>
 <scope>test</scope>
</dependency>
4. Maven selenium dependency
https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.17.0
<dependency>
 <groupId>org.seleniumhq.selenium</groupId>
 <artifactId>selenium-java</artifactId>
 <version>4.17.0</version>
</dependency>
Right click on src/test/java
Create new package 
Name : com.herokuapp.theinternet
Now right click on same package com.herokuapp.theinternet and create new 
class.
Enter name : PositiveTest
The package and class will be created.
Create a method loginTest():
public void loginTest()
{
WebDriver driver=new ChromeDriver();
}
When red line will show just press control + shift + alphabet o 
Do same red line concept here:
WebElement username=driver.findELement(By.xpath(url))
5.Get chrome extension Ranorex Selocity:
https://chromewebstore.google.com/detail/ranorex-selocity/ocgghcnnjekfpbmafindjmijdpopafoe
Add to browser and restart browser.
6.open the website.
https://the-internet.herokuapp.com/login
In the page:
Right click on username and select action copy xpath and paste on url.
Do same for password.
Add loginbtn and do same with xpath and send on login btn click.
Copy username and password and paste it.
7.Now add @Test before this code
public class PositiveTest {
public void loginTest()
{
WebDriver driver=new ChromeDriver();
String url="https://the-internet.herokuapp.com/login";
driver.get(url);
driver.manage().window().maximize();
WebElement 
username=driver.findElement(By.xpath("/html//input[@id='username'"));
username.sendKeys("tomsmith");
WebElement 
password=driver.findElement(By.xpath("/html//input[@id='password'"));
password.sendKeys("SuperSecretPassword!");
WebElement 
loginbtn=driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
loginbtn.click();
driver.close();
}
}
After adding test there will be red line.
just go to test and wait and then click on import test.
8. Now open cmd again and go to folder file path where it is saved.
Go to eclipse workspace and folder which you might created.