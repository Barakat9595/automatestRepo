package testTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class TestClassOne {
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://duckduckgo.com/");
    }
    @Test
    public void taskProblemOne (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getTitle(),"Google");
        softAssert.assertAll();

    }

    @Test
    public void taskProblemTwo()
    {
        SoftAssert softAssert = new SoftAssert();
        By logo = By.xpath("//*[@id=\"__next\"]/div/main/article/div[1]/div[1]/div[2]/div/header/div/section[1]/a/img");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement waitedLogo = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
        boolean isDisplayed = waitedLogo.isDisplayed();
        softAssert.assertTrue(isDisplayed);
        softAssert.assertAll();
    }
    @Test
    public void taskProblemThree(){
        SoftAssert softAssert = new SoftAssert();
        By searchBar = By.id("searchbox_input");
        By searchBtn = By.xpath("//button[@aria-label='Search']");
        By firstResult = By.xpath("//span[text()='WebDriver - Selenium']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       WebElement waitedBar = wait.until(ExpectedConditions.visibilityOfElementLocated(searchBar));
       // a jump over to the assertion then to the quit. (solved when each waitedElement is before it's interaction

       waitedBar.sendKeys("Selenium WebDriver");
        WebElement waitedSearchBtn =  wait.until(ExpectedConditions.presenceOfElementLocated(searchBtn));
       waitedSearchBtn.click();
        WebElement waitedResult = wait.until(ExpectedConditions.presenceOfElementLocated(firstResult));
       waitedResult.click();

        String URL = driver.getCurrentUrl();
        softAssert.assertEquals(URL, "https://www.selenium.dev/documentation/webdriver/");
        softAssert.assertAll();

    }
    @AfterMethod
    public void quit()
    {
        driver.quit(); //quit can be before soft assert to pass all the statementss before running assertion
    }
}
