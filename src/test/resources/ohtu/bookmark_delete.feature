Feature: User can delete bookmarks.

    Scenario: delete is successful
        Given new book has been added
        When book is deleted
        Then book isn't listed