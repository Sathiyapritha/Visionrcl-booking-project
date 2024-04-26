package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CommonFunctions {
 public static WebDriver driver;
    //  public static String futureDt;

    public static void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    public static void closeBrowser() {
        // driver.close();
        //  driver.quit();

    }

    public static void waitForTime(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    }

    public static void waitForElementsToVisible(WebDriver driver, Duration duration, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementsToClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void sendType(WebElement element, String data) {
        element.sendKeys(data);
    }

    public static void navigateToUrl(String url) {
        driver.get(url);
    }

    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void clickBtn(WebElement element) {
        element.click();
    }

    public static void selectOptionByText(WebElement element, String data) {
        new Select(element).selectByVisibleText(data);
    }

    public static void assertEquals(String expected, String actual) {
        Assert.assertEquals(expected, actual);
    }

    public static void isElementDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    public static void executeJs(String script, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(script, element);
    }

    public static void clickElementJs(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click;", element);
    }

    public static String calenderDate(WebElement element) {

        LocalDate currentDate = LocalDate.now();
        LocalDate seventhDate = currentDate.plusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String strSeventhDate = seventhDate.format(formatter);
        String currentDate1 = currentDate.format(formatter);
       /* System.out.println("Current date is: " +currentDate1);
        System.out.println("Seventh date from current date is: " +strSeventhDate);*/
        // futureDt = strSeventhDate;
        return strSeventhDate;

    }



    /*public static void badmintonCourtNames(List<WebElement> badmintonCourt) {
        System.out.println("Size: " +badmintonCourt.size());
        for (WebElement courtList : badmintonCourt) {
           // if (courtList.getText().contains("Badminton"))  // Siva commented
            String listName = courtList.getText();
            System.out.println("Space available in Badminton court are : " +listName);

        }

       }*/

/*    public static void commonSpaceButton(List<WebElement> spaceBtn) {

        for (WebElement clkButton : spaceBtn){

            clkButton.click();


            }
    }*/

  /*  public static void applyKey(Keys key) {
        Actions act = new Actions(driver);
        //instead of using this line of code for entering keyboard actions through send keys we use 2nd line of code
        //act.sendKeys(Keys.ENTER).perform();
        act.sendKeys(key).perform();
    }*/


}//common fn main end brace

