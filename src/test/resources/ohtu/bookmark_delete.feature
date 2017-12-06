Feature: User can delete bookmarks.

  Scenario: book deletion is successful
    Given books are selected
    When author "Akira Toriyama" and book name "The Winning Universe is Decided!" and ISBN "978-4-08-880867-3" are submitted
    And book "The Winning Universe is Decided!" is selected
    And book is deleted
    Then book by name "The Winning Universe is Decided!" is not listed anymore

  Scenario: video deletion is succesful
    Given videos are selected
    When title "Cat video #2" and video url "https://www.youtube.com/watch?v=cbP2N1BQdYc" are submitted
    And video "Cat video #2" is selected
    And video is removed
    Then video by name "Cat video #2" is listed no more
