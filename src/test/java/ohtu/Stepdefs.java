package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class Stepdefs {

    WebDriver driver = new HtmlUnitDriver();
    String baseUrl = "http://localhost:4567/";

    public Stepdefs() {
        driver.get(baseUrl);
    }

    @Given("^books are selected$")
    public void add_selected() throws Throwable {
        WebElement element = driver.findElement(By.linkText("Books"));
        element.click();
    }

    @When("^author \"([^\"]*)\" and book name \"([^\"]*)\" and ISBN \"([^\"]*)\" are submitted")
    public void author_and_book_name_are_given(String author, String title, String ISBN) throws Throwable {
        WebElement element = driver.findElement(By.name("author"));
        element.sendKeys(author);
        element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("ISBN"));
        element.sendKeys(ISBN);
        element = driver.findElement(By.name("submitbook"));
        element.click();
    }

    @Then("^book named \"([^\"]*)\" has been added$")
    public void user_has_added_new_bookmark(String title) throws Throwable {
        pageHasContent(title);
    }


    @Given("^new book has been added$")
    public void new_book_has_been_added() throws Throwable {
        WebElement element = driver.findElement(By.linkText("Books"));
        element.click();
        element = driver.findElement(By.name("title"));
        element.sendKeys("Introduction to the Theory of Computation");
        element = driver.findElement(By.name("author"));
        element.sendKeys("Michael Sipser");
        element = driver.findElement(By.name("ISBN"));
        element.sendKeys("978-1133187790");
        element = driver.findElement(By.name("tags"));
        element.sendKeys("Laskennan mallit");
        element = driver.findElement(By.name("submitbook"));
        element.click();
    }

    @When("^book is deleted$")
    public void book_is_deleted() throws Throwable {
        WebElement element = driver.findElement(By.name("poispois"));
        element.click();

    }

    @Then("^book isn't listed$")
    public void book_isn_t_listed() throws Throwable {
        pageHasNoContent("Introduction to the Theory of Computation");
    }

    @Given("^book has been selected to be edit$")
    public void book_has_been_selected_to_be_edit() throws Throwable {
        WebElement element = driver.findElement(By.name("bookInstance"));
        element.click();
         element = driver.findElement(By.linkText("Edit"));
        element.click();
    }

    @When("^user change title to \"([^\"]*)\"$")
    public void user_change_title_to(String title) throws Throwable {
        WebElement element = driver.findElement(By.name("title"));
        element.sendKeys(title);
       element = driver.findElement(By.name("send"));
        element.click();
    }

    @When("^user change author to \"([^\"]*)\"$")
    public void user_change_author_to(String author) throws Throwable {
        WebElement element = driver.findElement(By.name("author"));
        element.sendKeys(author);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @When("^user change tags to \"([^\"]*)\"$")
    public void user_change_tags_to(String tags) throws Throwable {
        WebElement element = driver.findElement(By.name("tags"));
        element.sendKeys(tags);
    element = driver.findElement(By.name("send"));
        element.click();
    }

    @When("^user change ISBN to \"([^\"]*)\"$")
    public void user_change_ISBN_to(String isbn) throws Throwable {
        WebElement element = driver.findElement(By.name("ISBN"));
        element.sendKeys(isbn);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @Then("^book data contains \"([^\"]*)\"$")
    public void book_data_contains(String arg1) throws Throwable {
        pageHasContent(arg1);
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    /* helper methods */
    private void pageHasNoContent(String content) {
        assertFalse(driver.getPageSource().contains(content));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
