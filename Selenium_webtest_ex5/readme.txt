Web Testing Using Selenium:

Website: http://testphp.vulnweb.com/userinfo.php

Aim: Perform web testing using Selenium and execute the following steps:

Login to the website
Enter text into Notepad
Update text content on the website
Procedure:

a. Open a web browser and log in

b. Retrieve and manipulate text content on the webpage

Steps:

Create a Project:

Project Name: Selenium_webtest_ex5
Update pom.xml:

Change 'http' to 'https'
Add dependencies and plugins:
Code:

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

Create Test Class:

Right-click on src/test/java
Create a new package (Name: com.herokuapp.theinternet)
Create a new class (Name: TestHero)
TestHero.java Code:
Code:

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

Run Code:

Open cmd and navigate to the project file path
Run Code: mvn clean test