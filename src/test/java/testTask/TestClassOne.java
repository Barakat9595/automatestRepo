package testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestClassOne {
    @Test
    public void taskProblemOne (){
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        softAssert.assertEquals(driver.getTitle(),"Goodle");
        softAssert.assertAll();
        driver.quit();

    }

    @Test
    public void taskProblemTwo()
    {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        WebElement logo = driver.findElement(By.cssSelector(""));

        boolean isDisplayed = logo.isDisplayed();
        softAssert.assertTrue(isDisplayed);
        softAssert.assertAll();
        driver.quit();
    }
    @Test
    public void taskProblemThree()
    {
        SoftAssert softAssert = new SoftAssert();
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
        By searchBar = By.id("searchbox_input");
        By firstResult = By.xpath("//*[@id=\"r1-0\"]/div[3]/h2/a/span");
        driver.findElement(searchBar).sendKeys("Selenium WebDriver");
        driver.findElement(firstResult).click();
        String URL = driver.getCurrentUrl();
        softAssert.assertEquals(URL, "https://www.selenium.dev/documentation/webdriver/");
        softAssert.assertAll();
        driver.quit();

    }
}
