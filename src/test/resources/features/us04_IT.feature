@us04
Feature: As a data consumer, I want UI and DB book information are match.
@ui @db
  Scenario: Verify book information with DB
    Given the "librarian" on the home page IT
    And the user navigates to "Books" page IT
    When the user searches for "Lord of the Files" book IT
    And  the user clicks edit book button IT
    Then book information must match the Database IT