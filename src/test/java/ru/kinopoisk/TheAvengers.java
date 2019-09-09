package ru.kinopoisk;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TheAvengers extends Hooks{

    @Test
    public void setMark() {
        driver.findElementByXPath("//input[@name='kp_query']").sendKeys("Мстители: Война бесконечности");
        driver.findElementByXPath("//button[contains(@class, 'header-fresh-search')]").click();
        driver.findElementByXPath("//a[text()='Мстители: Война бесконечности']").isDisplayed();

        driver.findElementByXPath("//a[text()='Мстители: Война бесконечности']").click();
        wait.until(ExpectedConditions.titleIs("Мстители: Война бесконечности (2018) — смотреть онлайн — КиноПоиск"));

        driver.findElementByXPath("//a[@class='s10']").click();
        Assert.assertTrue(driver.findElementByXPath("//*[@id=\"my_vote_text\"]").getAttribute("style").equals("background-position: -171px top;"));
    }
}
