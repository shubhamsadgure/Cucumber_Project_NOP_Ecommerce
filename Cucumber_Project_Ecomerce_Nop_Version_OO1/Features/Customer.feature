Feature: Customers

  Background: Commen Steps for Scenario
    Given User Launch Chrome Browser
    When Users Open URl "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And Users Enters Email As "admin@yourstore.com" and Password as "admin"
    And Click on the login button
    Then User can see the dashboard
  
  @sanity
  Scenario: Add new customer
    When User click on customer menu
    And click on customer menu item
    And click on add new customer button
    Then User can see add new customer page
    When User enter new customer info
    And Click on save button
    Then User can view confirmation message " The new customer has been added successfully."
    And Close the browser

  @regression
  Scenario: Search customer by EmailId
    When User click on customer menu
    And click on customer menu item
    And Enter customer email
    And click on search button
    Then user shoud found email in the search table
    And Close the browser

  @regression
  Scenario: Search customer by first and lst name
    When User click on customer menu
    And click on customer menu item
    And Enter customer first and last name
    And click on search button
    Then user shoud found first and last name in the search table
    And Close the browser
