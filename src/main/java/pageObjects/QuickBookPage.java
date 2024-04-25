package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

import java.io.File;
import java.io.FileWriter;


import java.io.IOException;
import java.time.Duration;
import java.util.List;


public class QuickBookPage {
   public WebDriver driver; // Siva

 FileWriter myFile;

    public QuickBookPage(WebDriver driver) {
       this.driver = driver;
      // Siva uncommented
        PageFactory.initElements(driver,this);

        //Siva Code
        try {
            myFile = new FileWriter("E:\\STT- rohin testing course videos\\Intellj-Automation-Practising folder\\VisionBookingPom\\src\\test\\java\\badminton.csv");
            myFile.write("Date,Court Name,Time"+"\n");
            System.out.println("File wrote");
        }
        catch (IOException e)
        {
            System.out.println("File Error");
        }
    }

    @FindBy(xpath = "(//h3[@class='panel-title'])[1]")
    public WebElement quickBookHeader;
    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement loxFordCentre;


    //(//input[@type='Date'])[1]
    @FindBy(css = ".form-control-inline")
    public WebElement datePicker;

    @FindBy(xpath = "//a[text()='Search']")
    public WebElement searchBtn;


    //@FindBy(xpath = "//div[contains(@class,'hidden')]//a[contains(text(),'Badminton Court')]/following-sibling::a[text()='Space']")
    @FindBy(xpath = "//a[contains(text(),'Badminton')]/following-sibling::a[text()='Space' and @data-qa-id]")
// @FindBy(xpath = "//a[contains(text(),'Badminton Court') and @data-qa-id]")
//@FindBy(xpath = "//div[contains(@class,'hidden')]//a[contains(text(),'Badminton Court')]")
    public List<WebElement> badmintonCourt;

/* @FindBy(xpath = "//a[contains(text(),'Badminton')]/following-sibling::a[text()='Space' and @data-qa-id]")
 public WebElement spaceBtn;*/

    @FindBy(xpath = "//a[contains(text(),'Badminton')]/following-sibling::a[text()='Space' and @data-qa-id]")
    public List<WebElement> spaceBtn;


    //div[contains(@id,'MainContent')]/table/tbody/tr[2]/td[1]/h3
    //*[@id='ctl00_MainContent_pnModifyInfo']/table/tbody/tr[2]/td[1]/h3
    //*/table/tbody/tr[2]/td[1]/h3
    @FindBy(xpath = "//*[@id='ctl00_MainContent_pnModifyInfo']/table/tbody/tr[2]/td[1]/h3")
    public WebElement badmintonSlotHeading;
    //td[@class='description']/h3

    @FindBy(xpath = "//*[@id='ClassStatusWrapper']/div[1]/div[1]")
//*[@id='ClassStatusWrapper']/div[1]/div[1]/h4
    public WebElement badmintonSlotHeading2;


    @FindBy(xpath = "//*[@id='ClassStatusWrapper']/div[1]/div[1]/h4[1]")
    public WebElement badmintonSlotHeading3;
    public void quickPageHeader(String actual) {

        CommonFunctions.assertEquals(actual, quickBookHeader.getText().trim());
    }

    public void dropDownLoxford(String data) {

        CommonFunctions.selectOptionByText(loxFordCentre,data);
        // new Select(element).selectByVisibleText(data);
    }

    public void currentDatePicker(){
        String strSeventhDate = CommonFunctions.calenderDate(datePicker);
        CommonFunctions.sendType(datePicker, strSeventhDate);
           //System.out.println("Current date is: " +currentDate1);
         System.out.println("Seventh date from current date is: " +strSeventhDate);
        //  CommonFunctions.clickBtn(datePicker);
    }

    public void dateSearchBtn() throws InterruptedException {
        CommonFunctions.clickBtn(searchBtn);
        //Thread.sleep(3000);
         CommonFunctions.waitForElementsToClickable(searchBtn);//necessary for the element to appear in the dom
       //CommonFunctions.waitForElementsToVisible((WebElement) badmintonCourt);
    }

    public void badmintonCourtList() {
        System.out.println("Size: " +badmintonCourt.size());
        for (WebElement courtList : badmintonCourt) {

            // if (courtList.getText().contains("Badminton"))  // Siva commented
            String listName = courtList.getText();
            System.out.println("Space available in Badminton court are : "+listName);

        }
        //    CommonFunctions.badmintonCourtNames(badmintonCourt);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void commonSpaceButton() throws InterruptedException, IOException {
        //  List<WebElement> spaceBtn = driver.findElements(By.xpath("//a[contains(text(),'Badminton')]/following-sibling::a[text()='Space' and @data-qa-id]"));

        System.out.println("Space button size: " +spaceBtn.size());



        for (int i = 0; i<spaceBtn.size(); i++) {
            spaceBtn.get(i).click();
              /*  for (WebElement clkButton : spaceBtn){
              clkButton.click();*/
            Thread.sleep(3000);
           System.out.println("-----------------------------------------------");
            System.out.println("Select Slot : " +badmintonSlotHeading.getText());
            System.out.println("Slot Timings: " +badmintonSlotHeading2.getText());
            String strSeventhDate = CommonFunctions.calenderDate(datePicker);
            // Siva code

            try {

                 myFile.write(strSeventhDate.trim()+','+badmintonSlotHeading.getText()+','+badmintonSlotHeading3.getText().replaceFirst("Mon 29 Apr,","")+'\n');
            }
            catch (IOException e)
            {
                System.out.println("File Error");
            }
            driver.navigate().back();

            CommonFunctions.sendType(datePicker, strSeventhDate);
            CommonFunctions.clickBtn(searchBtn);
            CommonFunctions.waitForElementsToClickable(searchBtn);//necessary for the element to appear in the dom
            //Thread.sleep(3000);
            //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));



        }
        try {
            myFile.close();
        }
        catch (IOException e)
        {
            System.out.println("File Error");
        }
    }


}//QuickBookpage class brace


