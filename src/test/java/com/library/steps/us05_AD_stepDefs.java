package com.library.steps;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us05_AD_stepDefs {

    @Given("Establish the database connection AD")
    public void establish_the_database_connection_ad() {}
    @When("I execute query to find most popular book genre AD")
    public void i_execute_query_to_find_most_popular_book_genre_ad() {
        String query = "select bc.name,count(*) from book_borrow bb\n" +
                "inner join books b on bb.book_id = b.id\n" +
                "inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc";
        DB_Util.runQuery(query);
    }
    @Then("verify {string} is the most popular book genre AD")
    public void verify_is_the_most_popular_book_genre_ad(String expectedBookGenre) {
        String actualBookGenre = DB_Util.getFirstRowFirstColumn();
        System.out.println("actualBookGenre = " + actualBookGenre);
        Assert.assertEquals(expectedBookGenre, actualBookGenre);
    }
}
