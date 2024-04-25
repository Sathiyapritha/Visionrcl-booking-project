package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.LoginPage;
import pageObjects.QuickBookPage;
import utils.CommonFunctions;

public class LoginSteps extends CommonFunctions {

    LoginPage loginPage = new LoginPage(driver);
    QuickBookPage quickBookPage = new QuickBookPage(driver);

    @Given("User should navigate to home page {string}")
    public void openHomePage(String url)
    {
     //   CommonFunctions.openBrowser();
        CommonFunctions.navigateToUrl(url);
    }

    @Then("User should enter email-id {string}")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @Then("User should enter password {string}")
    public void enterPassword(String password) {
    loginPage.enterPassword(password);
    }

    @When("User clicks login button")
    public void clicksLoginBtn() {
        loginPage.clickLoginBtn();

    }

    @Then("User should be fail with error message as {string}")
    public void loginErrorMessage(String actual)
    {
       loginPage.verifyLoginErrMsg(actual);

        System.out.println("The Error message for invalid login : "+actual);

    }


    /*@Then("User should be fail with error message")
    public void loginErrorMessage()
    {
        loginPage.verifyLoginErrMsg();
    }*/





}
