Ex3. AIM: To verify the login functionality of the website (https://the-internet.herokuapp.com/login).

Procedure:

Ensure that Java and Maven are installed on your system.

Open Eclipse IDE and create a Maven project within a new folder.

Configure the Maven project:

Group ID: com.herokuapp.theinternet
Artifact: Selenium_webtest
Name: Enter a name for the Selenium experiment.
Open the pom.xml file and replace 'http' with 'https'.

Install the following dependencies:

Compiler Plugin (https://maven.apache.org/plugins/maven-compiler-plugin/examples/set-compiler-source-and-target.html):

xml
Copy code
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
Surefire Plugin (https://maven.apache.org/surefire/maven-surefire-plugin/examples/testng.html):

xml
Copy code
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
Testing dependency (https://mvnrepository.com/artifact/org.testng/testng/7.9.0):

xml
Copy code
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
</dependency>
Selenium dependency (https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.17.0):

xml
Copy code
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.17.0</version>
</dependency>
In Eclipse, right-click on src/test/java, create a new package (Name: com.herokuapp.theinternet), and within the same package, create a new class (Name: PositiveTest).

Implement the loginTest() method:

java code
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
Add the @Test annotation to the PositiveTest class.

Save and import the required test dependencies.

Open the command prompt, navigate to the project folder, and go to the Eclipse workspace where the project is saved.