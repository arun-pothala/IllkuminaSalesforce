Feature: Salesforce Tests

  Background:
    Given user is on the Salesforce login page
    When user login with username "pothala.arun-hcnt@force.com" and password "Florida01"

  @login
  Scenario: Successful login with valid credentials
    Then verify salesforce homepage is displayed

  @search
  Scenario Outline: Verify Search returns accurate results
    When user search with "<searchKeyword>"
    Then verify search result shows "<searchKeyword>"

    Examples:
      | searchKeyword |
      | Accounts      |

  @createAccount
  Scenario Outline: Verify user is able to create account
    When user clicks on Account
    And user clicks on new account
    And user enter account name "<accountName>"
    And user click on save on Create Account modal
    Then Verify the account is created successfully with "<accountName>"

    Examples:
      | accountName       |
      | testAutomation123 |

  @createContact
  Scenario Outline: Verify user is able to create contact
    When user clicks on Account
    And user clicks on first Account
    And user clicks on create new contact
    And user enter the contact lastName "<lastName>"
    And user click on save in create contact modal
    Then verify the contact "<lastName>" reflects in contacts section

    Examples:
      | lastName     |
      | testLastName |

  @logout
  Scenario: Verify logout is successful
    When user clicks on user profile icon
    And user clicks on logout
    Then verify login page is displayed


