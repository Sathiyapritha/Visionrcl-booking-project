Feature: Quick book page feature
  As a user
  I should select Loxford Leisure Centre

  Background:
    Given User should navigate to home page "https://visionrcl.leisurecloud.net/Connect/mrmLogin.aspx"
    Then User should enter email-id "sathiyatesting04@gmail.com"
    Then User should enter password "Visiontest@24"
    When User clicks login button


  Scenario: Verify user should landed on search
    Given user should landed successfully on Quick book page "QuickBook"
    Then User should select "Loxford Leisure Centre"
#Loxford Leisure Centre

@testBook
  Scenario: Validate whether the user can book slots in badminton court
    Given User should enter seventh date from current date
    When User should click on search button
    And User should get Badminton courts list
    And user should click on space button
    And User should see Badminton court heading
    And User should get date and timings
    And User should click on book button
    Then User should see the "Complete Your Booking" page