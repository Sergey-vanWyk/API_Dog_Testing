Feature: Users gets a message after looking for random dog on Dog API

  Scenario: Client searches for random dog

    Given client is on the home page
    When the clients wants to look at random dogs
    Then a successful message must be received