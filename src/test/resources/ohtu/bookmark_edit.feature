Feature: user can edit existing (book)marks

  Scenario: user can edit an existing (book)mark
    Given books are selected
    When author "Akira Toriyama" and book name "The Winning Universe is Decided!" and ISBN "978-4-08-880867-3" are submitted
    And book "The Winning Universe is Decided!" is selected
    And edit button is selected
    And author "Akira Toriyama" and book name "Zero Mortals Plan" and ISBN "978-4-08-881084-3" are new values of the book
    Then book named "The Winning Universe is Decided!" has been edited and its new name is "Zero Mortals Plan"
