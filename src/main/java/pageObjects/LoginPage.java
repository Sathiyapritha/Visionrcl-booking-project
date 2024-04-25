package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonFunctions;

public class LoginPage{

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[text()='Login']")
    public WebElement LoginHeader;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameTxtFld;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordTxtFld;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "(//div[@class='form-main']/div)[2]")
    public WebElement loginErrorMsg;

    //Actions to be performed for above find WebElements
    public void loginPageHeader() {

        CommonFunctions.isElementDisplayed(LoginHeader);
    }

    public void enterUsername(String username) {
        CommonFunctions.sendType(usernameTxtFld,username);
       // usernameTxtFld.sendKeys(username);// can use this parameter method to send data using sendkeys
    }

    public void enterPassword(String password)
    {
        CommonFunctions.sendType(passwordTxtFld,password);
    }

    public void clickLoginBtn()
    {

        CommonFunctions.clickBtn(loginBtn);
    }

    public void verifyLoginErrMsg(String actual){

       CommonFunctions.assertEquals(actual, loginErrorMsg.getText());

        }

    /*public void verifyLoginErrMsg()
    {
        //Assert.assertTrue(loginErrorMsg.getText().contains(expected));
        CommonFunctions.isElementDisplayed(loginErrorMsg);
    }*/

}// Login page end braces
