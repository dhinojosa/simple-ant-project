package com.xyzcorp;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SeleniumTest {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();
    private boolean acceptNextAlert = true;

    @Before
    @Category(AcceptanceTest.class)
    public void setUp() throws MalformedURLException {
        baseUrl = "http://google.com";
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver
                (new URL("http://192.168.57.1:4444/wd/hub"), capability);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    @Category(AcceptanceTest.class)
    public void testSeleniumBacked() throws Exception {
        driver.get(baseUrl + "about:startpage");
        driver.findElement(By.id("sbi")).clear();
        driver.findElement(By.id("sbi")).sendKeys("Birds of the Southwest");
        driver.findElement(By.id("sbtn")).click();
        driver.findElement(By.linkText("Category:Native birds of the Southwestern United States ...")).click();
        assertEquals("Broad-billed hummingbird", driver.findElement(By.linkText("Broad-billed hummingbird")).getText());
        assertEquals("Lucifer sheartail", driver.findElement(By.linkText("Lucifer sheartail")).getText());
        driver.findElement(By.linkText("Lucifer sheartail")).click();
        assertEquals("Calothorax lucifer", driver.findElement(By.cssSelector("p > i")).getText());
        System.out.println("Println in Selenium");
    }

    @After
    @Category(AcceptanceTest.class)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
