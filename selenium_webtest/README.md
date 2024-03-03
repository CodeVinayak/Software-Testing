**Ex3.**

**AIM:** To verify the login functionality of the website [https://the-internet.herokuapp.com/login](https://the-internet.herokuapp.com/login).

**Procedure:**

1. Ensure that **Java** and **Maven** are installed on your system.
2. Open **Eclipse IDE** and create a **Maven project** within a new folder.
3. Configure the Maven project:
   - Group ID: com.herokuapp.theinternet
   - Artifact: Selenium_webtest
   - Name: Enter a name for the Selenium experiment.
4. Open the **pom.xml** file and replace 'http' with 'https'.
5. Install the following dependencies:

   - **Compiler Plugin (Maven Compiler):**
     ```xml
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
     ```

   - **Surefire Plugin (Maven Surefire):**
     ```xml
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
     ```

   - **Testing Dependency (TestNG):**
     ```xml
     <dependency>
         <groupId>org.testng</groupId>
         <artifactId>testng</artifactId>
         <version>7.9.0</version>
         <scope>test</scope>
     </dependency>
     ```

   - **Selenium Dependency:**
     ```xml
     <dependency>
         <groupId>org.seleniumhq.selenium</groupId>
         <artifactId>selenium-java</artifactId>
         <version>4.17.0</version>
     </dependency>
     ```

6. In Eclipse, right-click on **src/test/java**, create a new package (Name: com.herokuapp.theinternet), and within the same package, create a new class (Name: PositiveTest).

7. Implement the `loginTest()` method:

   ```java
   public void loginTest() {
       WebDriver driver = new ChromeDriver();
       String url = "https://the-internet.herokuapp.com/login";
       driver.get(url);
       driver.manage().window().maximize();
       WebElement username = driver.findElement(By.xpath("/html//input[@id='username'"));
       username.sendKeys("tomsmith");
       WebElement password = driver.findElement(By.xpath("/html//input[@id='password'"));
       password.sendKeys("SuperSecretPassword!");
       WebElement loginbtn = driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
       loginbtn.click();
       driver.close();
   }

1. Add the @Test annotation to the PositiveTest class.

2. Save and import the required test dependencies.

3. Open the command prompt, navigate to the project folder, and go to the Eclipse workspace where the project is saved.