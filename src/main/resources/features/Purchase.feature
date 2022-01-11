@Test
Feature: Purchase a gadget from Demoblaze website

  In order to purchase a product of my preference
  I need to add to card and make payment on the website

  Scenario Outline: Add and Checkout a product from cart and make payment online
    When User selects category "<category>"
    And User selects the product "<product>"
    And User adds the product to cart
    And User verifies the product in cart
    And User places the order with buyer name <"name"> and country <"country"> and city "<city>" and credit card "<card>" and month "<month>" and year "<year>"
    And User verifies order success

    Examples:
    |category|product      |name|country|city  |card               |month|year
    |Phones  |Iphone 6 32gb|Dave|US     |Boston|4811 1111 1111 1114|12   |2024