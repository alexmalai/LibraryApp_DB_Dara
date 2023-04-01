package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us07_IK_Stepdefs {

    LoginPage loginPage = new LoginPage();

    BookPage bookPage = new BookPage();
    @Given("the {string} on the home page")
    public void the_on_the_home_page(String string) {
        loginPage.login("student");
    }
    @Given("the user navigates to {string} page")
    public void the_user_navigates_to_page(String string) {
        bookPage.navigateModule("Books");
    }
    String bookName;
    @Given("the user searches for {string} book")
    public void the_user_searches_for_book(String string) {
        bookName = string;
        bookPage.search.sendKeys(bookName);
    }
    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {
        bookPage.borrowBook(bookName);
    }

    String pageName;
    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String string) {
        BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();
        pageName = string;
        new DashBoardPage().navigateModule(pageName);
        Assert.assertTrue(BrowserUtil.getElementsText(borrowedBooksPage.allBorrowedBooksName).contains(bookName));
    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }
}
