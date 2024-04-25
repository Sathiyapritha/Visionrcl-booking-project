package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.QuickBookPage;
import utils.CommonFunctions;

import java.io.IOException;

public class QuickBookStep extends CommonFunctions {
    QuickBookPage quickBookPage = new QuickBookPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Then("user should landed successfully on Quick book page {string}")
    public void quickBookPage(String actual)
    {
        quickBookPage.quickPageHeader(actual);
        System.out.println("You are in : "+actual);
    }

    @Then("User should select {string}")
    public void userShouldSelect(String data)
    {
        quickBookPage.dropDownLoxford(data);
        System.out.println("Center name is: "+data);
    }

    //Date picker code starts from here


    @Given("User should enter seventh date from current date")
    public void enterSeventhDate(){

       quickBookPage.currentDatePicker();

       // quickBookPage.currentDatePicker(strSeventhDate);
    }

    @When("User should click on search button")
    public void searchButton() throws InterruptedException {
        quickBookPage.dateSearchBtn();
    }

    @Then("User should get Badminton courts list")
    public void courtsList() {
       quickBookPage.badmintonCourtList();

    }
   /* @Then("user should click on space button")
    public void spaceButton(){
        quickBookPage.badminSpaceBtn();
    }
    */


    //List of webelements in space button
    @Then("user should click on space button")
    public void spaceButton() throws InterruptedException, IOException {
        quickBookPage.commonSpaceButton();
    }

    @When("User should see Badminton court heading")
    public void badmintonCourtHeading() {

    }

    @Then("User should get date and timings")
    public void userShouldGetDateAndTimings() {

    }
    @Then("User should click on book button")
    public void userShouldClickOnBookButton() {

    }

    @Then("User should see the {string} page")
    public void userShouldSeeThePage(String string) {

    }



}//Quick Book close bracket
