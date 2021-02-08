package examProject.features.search;

import examProject.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/features/search/data.csv")
public class BookExpressStoryCSVData {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public EndUserSteps steps;

    String bookTitle;

    @Issue("search for a book")
    @Test
    public void search_book() {

        steps.go_to_home_page();
        steps.add_credentials_and_login(System.getProperty("username"),  System.getProperty("password"));
        steps.search_book(bookTitle);
        steps.verify_searched_book(bookTitle);
    }
}
