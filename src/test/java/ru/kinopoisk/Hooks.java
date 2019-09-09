package ru.kinopoisk;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Hooks {

    public ChromeDriver driver;
    public WebDriverWait wait;

    @Before
    public void login() {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        driver.get("https://www.kinopoisk.ru/");
        Assert.assertTrue(driver.getTitle().equals("КиноПоиск — Все фильмы планеты"));

        driver.findElementByXPath("//button[text()='Войти']").click();
        Assert.assertTrue(driver.getTitle().equals("Авторизация"));

        driver.findElementByXPath("//input[@name='login']").sendKeys("c86539@urhen.com");
        Assert.assertTrue(driver.findElementByXPath("//input[@name='login']").getAttribute("value").equals("c86539@urhen.com"));
        driver.findElementByXPath("//button[contains(@class, 'passp-form-button')]").click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));
        driver.findElementByXPath("//*[@id='passp-field-passwd']").sendKeys("Qwerty123");
        Assert.assertTrue(driver.findElementByXPath("//*[@id='passp-field-passwd']").getAttribute("value").equals("Qwerty123"));
        driver.findElementByXPath("//button[contains(@class, 'passp-form-button')]").click();
        wait.until(ExpectedConditions.titleIs("КиноПоиск — Все фильмы планеты"));
    }

    @After
    public void close() {
        driver.quit();
    }
}
