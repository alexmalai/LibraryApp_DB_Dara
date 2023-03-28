@db
Feature: As a data consumer, I want to know genre of books are being borrowed the most

  Scenario: verify the the common book genre that’s being borrowed
    Given Establish the database connection AD
    When I execute query to find most popular book genre AD
    Then verify "Fantasy" is the most popular book genre AD