package ohtu;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ohtu.Dao.BookDao;
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
    public void books_are_selected() throws Throwable {
        WebElement element = driver.findElement(By.linkText("Books"));
        element.click();
    }

    @Given("^videos are selected")
    public void videos_are_selected() throws Throwable {
        WebElement element = driver.findElement(By.linkText("Videos"));
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

    @When("^author \"([^\"]*)\" and book name \"([^\"]*)\" and ISBN \"([^\"]*)\" are new values of the book")
    public void author_and_book_name_and_isbn_are_edited(String newAuthor, String newTitle, String newISBN) {
        WebElement element = driver.findElement(By.name("author"));
        element.clear();
        element.sendKeys(newAuthor);
        element = driver.findElement(By.name("title"));
        element.clear();
        element.sendKeys(newTitle);
        element = driver.findElement(By.name("ISBN"));
        element.clear();
        element.sendKeys(newISBN);
        element = driver.findElement(By.name("send"));
        element.clear();
        element.click();
    }

    @When("^book \"([^\"]*)\" is selected")
    public void book_name_is_selected(String title) {
        WebElement element = driver.findElement(By.linkText(title));
        element.click();
    }

    @Then("^book named \"([^\"]*)\" has been added$")
    public void user_has_added_new_bookmark(String title) throws Throwable {
        pageHasContent(title);
    }

    @Then("^book named \"([^\"]*)\" has not been added$")
    public void book_named_has_not_been_added(String arg1) throws Throwable {
        pageHasNoContent(arg1);
    }

    @Then("^book named \"([^\"]*)\" has been edited and its new name is \"([^\"]*)\"")
    public void user_has_changed_the_name_of_an_existing_bookmark(String originalTitle, String newTitle) {
        pageHasNoContent(originalTitle);
        pageHasContent(newTitle);
    }

    @Given("^new book has been added$")
    public void new_book_by_sipser_has_been_added() throws Throwable {
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

    @When("^edit button is pressed")
    public void book_edit_button_has_been_pressed() {
        WebElement element = driver.findElement(By.name("editbutton"));
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
        element.clear();
        element.sendKeys(title);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @When("^user change author to \"([^\"]*)\"$")
    public void user_change_author_to(String author) throws Throwable {
        WebElement element = driver.findElement(By.name("author"));
        element.clear();
        element.sendKeys(author);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @When("^user change tags to \"([^\"]*)\"$")
    public void user_change_tags_to(String tags) throws Throwable {
        WebElement element = driver.findElement(By.name("tags"));
        element.clear();
        element.sendKeys(tags);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @When("^user change ISBN to \"([^\"]*)\"$")
    public void user_change_ISBN_to(String isbn) throws Throwable {
        WebElement element = driver.findElement(By.name("ISBN"));
        element.clear();
        element.sendKeys(isbn);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @Then("^book data contains \"([^\"]*)\"$")
    public void book_data_contains(String arg1) throws Throwable {
        pageHasContent(arg1);

    }

    @Then("^book by name \"([^\"]*)\" is not listed anymore$")
    public void book_by_name_is_not_listed_anymore(String title) throws Throwable {
        pageHasNoContent(title);
    }

    @When("^title \"([^\"]*)\" and video url \"([^\"]*)\" are submitted$")
    public void title_and_video_url_are_submitted(String title, String url) throws Throwable {
        WebElement element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("url"));
        element.sendKeys(url);
        element = driver.findElement(By.name("submitvideo"));
        element.click();
    }

    @Then("^video named \"([^\"]*)\" has been added$")
    public void video_named_has_been_added(String videoTitle) throws Throwable {
        pageHasContent(videoTitle);
    }

    @When("^video \"([^\"]*)\" is selected$")
    public void video_is_selected(String videoTitle) throws Throwable {
        WebElement element = driver.findElement(By.linkText(videoTitle));
        element.click();
    }

    @When("^video is removed$")
    public void video_is_removed() throws Throwable {
        WebElement element = driver.findElement(By.name("poispois"));
        element.click();
    }

    @Then("^video by name \"([^\"]*)\" is listed no more$")
    public void video_by_name_is_listed_no_more(String videoTitle) throws Throwable {
        pageHasNoContent(videoTitle);
    }

    @When("^new name \"([^\"]*)\" is given to the video$")
    public void new_name_is_given_to_the_video(String title) throws Throwable {
        WebElement element = driver.findElement(By.name("title"));
        element.sendKeys(title);
        element = driver.findElement(By.name("send"));
        element.click();
    }

    @Then("^video is named \"([^\"]*)\"$")
    public void video_is_named(String newTitle) throws Throwable {
        pageHasContent(newTitle);
    }

    /* helper methods */
    private void pageHasContent(String content) {
        assertTrue(driver.getPageSource().contains(content));
    }

    private void pageHasNoContent(String content) {
        assertFalse(driver.getPageSource().contains(content));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
