@Test
Feature: Test Login Functionality

  In order to purchase a product of my preference
  I need to login to the website

  Background:
    Given User launches website
    And Navigates to login page

  Scenario Outline: User login should fail with incorrect credentials
    When User enters incorrect username "<username>"
    And User enters incorrect password "<password>"
    Then Login should fail

    Examples:
    |username|password|
    |DDave    |Dave123 |

    Scenario Outline: User should login successfully with correct credentials
      When User enters correct username "<username>"
      And User enters correct password "<password>"
      Then Login should pass

      Examples:
        |username|password|
        |Dave    |Ddave25 |

