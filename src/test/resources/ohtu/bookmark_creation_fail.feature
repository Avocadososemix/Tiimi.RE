Feature: user cannot add a book with too short name

  Scenario: addition is unsuccesful
    Given books are selected
    When author "Akira Toriyama" and book name "zz" and ISBN "978-4-08-880867-3" are submitted
    Then book named "zz" has not been added
