package ru.kinopoisk;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;


public class TheAvengers {

    @Test
    public void fistTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\src\\main\\resources\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://www.kinopoisk.ru/");

        driver.findElementByXPath("//button[text()='Войти']").click();
        driver.findElementByXPath("//input[@name='login']").sendKeys("c86539@urhen.com");
        driver.findElementByXPath("//button[contains(@class, 'passp-form-button')]").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id='passp-field-passwd']").sendKeys("Qwerty123");
        driver.findElementByXPath("//button[contains(@class, 'passp-form-button')]").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//input[@name='kp_query']").sendKeys("Мстители: Война бесконечности");
        driver.findElementByXPath("//button[contains(@class, 'header-fresh-search')]").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//a[text()='Мстители: Война бесконечности']").click();
        Thread.sleep(1000);
        driver.findElementByXPath("//a[@class='s10']").click();
   //     driver.quit();
    }
}
