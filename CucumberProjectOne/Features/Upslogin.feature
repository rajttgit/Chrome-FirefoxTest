Feature: Ups Login Feature
  This login feature is for login functionality in UPS website
  
  @chrome
  Scenario Outline: Login with wrong user id and password
    Given I navigated to ups login page
    And I entered wrong "<userid>" and "<password>"
    When I click on login
    Then I should receive an error message

    Examples: 
      | userid	| password  |
      | user1  	| password1	|
      | user2   | password2 |
      
      
  @firefox
  Scenario Outline: Login with wrong user id and password
    Given I navigated to ups login page
    And I entered wrong "<userid>" and "<password>"
    When I click on login
    Then I should receive an error message

    Examples: 
      | userid	| password  |
      | user1  	| password1	|
      | user2   | password2 |