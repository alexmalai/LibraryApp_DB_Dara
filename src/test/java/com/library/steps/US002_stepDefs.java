package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class US002_stepDefs {

    String actualNumberOfBooks;

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        loginPage.login("librarian");

    }
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {
        actualNumberOfBooks= dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualNumberOfBooks = " + actualNumberOfBooks);

    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        String query = "select count(*) from book_borrow where is_returned = 0";
        DB_Util.runQuery(query);
        String expectedNumberOfBooks = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedNumberOfBooks = " + expectedNumberOfBooks);

        Assert.assertEquals(expectedNumberOfBooks,actualNumberOfBooks);


    }
}
