Feature: Login

  @sanity
  Scenario: Successful Loging Withe Valid Credentials
    Given User Launch Chrome Browser
    When Users Open URl "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And Users Enters Email As "admin@yourstore.com" and Password as "admin"
    And Click on the login button
    And Page Title Should be "Dashboard / nopCommerce administration"
    When User click on the logout button
    Then logout page title should be "Your store. Login"
    And Close the browser
    
    
  @regression
  Scenario Outline: Login data driven1
    Given User Launch Chrome Browser
    When Users Open URl "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And Users Enters Email As "<Email1>" and Password as "<Password1>"
    And Click on the login button
    And Page Title Should be "Dashboard / nopCommerce administration"
    When User click on the logout button
    Then logout page title should be "Your store. Login"
    And Close the browser

    Examples: 
      | Email1              | Password1 |
      | admin@yourstore.com | admin     |
      
  @datadriven
  Scenario Outline: Login data driven2
    Given User Launch Chrome Browser
    When Users Open URl "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And Users Enters Email As "<Email2>" and Password as "<Password2>"
    And Click on the login button
    Then Failed login Page Title Should be "Login was unsuccessful. Please correct the errors and try again."
    And Close the browser

    Examples: 
      | Email2               | Password2 |
      | admin1@yourstore.com | admin1    |
      | admin2@yourstore.com | admin2    |
