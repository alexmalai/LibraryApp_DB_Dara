@us06
Feature: Books module
  As a librarian, I should be able to add new book into library

  @ui@db
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page
    And the user navigates to "Books" page
    When the librarian click to add book
    And the librarian enter book name "<Book Name>"
    When the librarian enter ISBN "<ISBN>"
    And the librarian enter year "<Year>"
    When the librarian enter author "<Author>"
    And the librarian choose the book category "<Book Category>"
    And the librarian click to save changes
    Then verify "The book has been created" message is displayed
    And verify "<Book Name>" information must match with DB
    Examples:
      | Book Name             | ISBN     | Year | Author      | Book Category        |
      | Ali Can in Wonderland | 10112022 | 2023 | Raffi Gocer | Action and Adventure |
      | Sanli Kanarya Tarihi  | 1907     | 1907 | Ali Can     | Classic              |