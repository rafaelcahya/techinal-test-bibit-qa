Feature: Buy Product on My Demo App Android

  Background:
    Given the app is launched
    When I navigate to the login page
    And I enter "bob@example.com" in the username field
    And I enter "10203040" in the password field
    And I tap the login button

  @buy
  Scenario: Buy Sauce Labs Backpack with blue color and quantity 2
    # Product Catalog
    When I tap on product "Sauce Labs Backpack"
    # Product Detail
    And I select color "Blue"
    And I set quantity to 2
    And I add the product to cart
    # Header
    And I tap the cart button
    # My Cart
    Then the product should be in the cart
    And I tap proceed to checkout
    # Shipping Address
    And I fill full name with "John Doe"
    And I fill address with "123 Main Street"
    And I fill city with "New York"
    And I fill zip code with "10001"
    And I fill country with "United States"
    And I tap to payment button
    # Payment
    And I fill payment name with "John Doe"
    And I fill card number with "1234567890123456"
    And I fill expiration date with "1234"
    And I fill security code with "123"
    And I tap review order button
    # Review Order
    And I tap place order button
    # Checkout Complete
    Then I should see checkout complete
