Feature: Decathlon Online Shopping
  As a customer
  I want to be able to browse and purchase products from Decathlon
  So that I can easily buy sports equipment and gear
  
  Background:
    Given I am on the Decathlon homepage
  
  Scenario: Browsing products
    When I navigate to the all section section
    And I select Running as my sport
    Then I should see a list of running-related products
    
  Scenario: Adding a product to the cart
    Given I am viewing a product page
    When I click on the Add to Cart button
    Then the product should be added to my shopping cart
    When I navigate to the shopping cart page
    And I click on the Remove button for a product
    Then the product should be removed from my cart
    
 


