package examProject.features.search;

import examProject.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BooksExpressStory {

    @Managed(uniqueSession = true)
    public WebDriver webDriver;

    @Steps
    public EndUserSteps steps;

    @Test
    public void login_user() {

        steps.go_to_home_page();
        steps.fill_data_and_login("oana.m.ujica@gmail.com", "2lBrj&icnl!", "JavaScript", webDriver);

        webDriver.quit();
    }

//    @Test
//    public void search_book() {
//        steps.search_book();
//    }
}
