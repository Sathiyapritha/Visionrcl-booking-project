Feature: Visionrlc Leisure Center Booking app login feature

  @login
  Scenario: Login Should be successfully with valid credentials
    Given User should navigate to home page "https://visionrcl.leisurecloud.net/Connect/mrmLogin.aspx"
    Then User should enter email-id "sathiyatesting04@gmail.com"
    Then User should enter password "Visiontest@24"
    When User clicks login button
   # Then user should landed successfully on Quick book page "QuickBook"

# Scenario: Login Should not be successful with Invalid credentials
#   Given User should navigate to home page "https://visionrcl.leisurecloud.net/Connect/mrmLogin.aspx"
#   Then User should enter email-id "hsassjhsadoasdu"
#   Then User should enter password "a38e8uh898"
#   When User clicks login button
#  Then User should be fail with error message as "Invalid Email Address or Password.\nPlease try again"


  Scenario Outline: Login Should be successfully with Invalid credentials
    Given User should navigate to home page "https://visionrcl.leisurecloud.net/Connect/mrmLogin.aspx"
    Then User should enter email-id "hsassjhsadoasdu"
    Then User should enter password "a38e8uh898"
    When User clicks login button
    Then User should be fail with error message as "<expected>"

    Examples:
    |expected |
    |Invalid Email Address or Password.\nPlease try again|



