Feature: user can edit existing (book)marks

  Scenario: user edits a whole book
    Given books are selected
    When author "Akira Toriyama" and book name "The Winning Universe is Decided!" and ISBN "978-4-08-880867-3" are submitted
    And book "The Winning Universe is Decided!" is selected
    And edit button is pressed
    And author "Akira Toriyama" and book name "Zero Mortals Plan" and ISBN "978-4-08-881084-3" are new values of the book
    Then book named "The Winning Universe is Decided!" has been edited and its new name is "Zero Mortals Plan"

  Scenario: user edits parts of a video
    Given videos are selected
    When title "Cat video #1" and video url "goo.gl/WIEH6J" are submitted
    And video "Cat video #1" is selected
    And edit button is pressed
    And new name "Funniest cat video of 2017" is given to the video
    Then video is named "Funniest cat video of 2017"
