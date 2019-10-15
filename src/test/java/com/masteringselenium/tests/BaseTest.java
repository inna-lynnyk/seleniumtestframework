
package com.masteringselenium.tests;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseTest {
    protected WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "//Users//inna.lynnyk//Git//seleniumtestframework//src//test//resources//drivers//chromedriver"); //drivers/chromedriver.exe
        driver = new ChromeDriver();
        System.out.println("Driver has been initialized");
        // initializes driver
        //driver = DriverFactory.getDriver();

        //Puts an Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Maximize the browser
        driver.manage().window().maximize();
        System.out.println("Driver has been configured");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
        System.out.println("Driver has been quite");
    }

    protected void openIndexPage() {
        driver.get("http://v3.test.itpmgroup.com");
    }
}
