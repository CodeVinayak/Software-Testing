**Web Testing Using Selenium:**

**Aim:** Perform web testing using Selenium and execute the following steps:

1. **Searching URL**
2. **Logout Button**
3. **Text Content**

**Procedure:**

a. Open a web browser

b. Navigate to the specified URL

c. Search for a specific URL

d. Locate and click on the Logout button

**Steps:**

**Create a Project:**

- **Project Name:** Selenium_webtest_ex4

**Update pom.xml:**

- Change 'http' to 'https'

**Add dependencies and plugins:**

```xml
<project xmlns="https://maven.apache.org/POM/4.0.0"
         xmlns:xsi="https://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
                             https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <!-- ... (existing configuration) ... -->
    <dependencies>
        <!-- TestNG -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.9.0</version>
            <scope>test</scope>
        </dependency>
        <!-- Selenium -->
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.17.0</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <!-- Compiler Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.12.1</version>
                <configuration>
                    <source>21</source>
                    <target>21</target>
                </configuration>
            </plugin>
            <!-- Surefire Plugin -->
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.2.5</version>
            </plugin>
        </plugins>
    </build>
</project>
```
Create Test Class:

1.Right-click on src/test/java

2.Create a new package (Name: com.herokuapp.theinternet)

3.Create a new class (Name: PositiveTest)

PositiveTest.java Code:
 ```xml
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
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        driver.manage().window().maximize();
        sleep(2);
        // ... (rest of the existing code)
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
```
Run Code:

Open cmd and navigate to the project file path

Run Code: mvn clean test