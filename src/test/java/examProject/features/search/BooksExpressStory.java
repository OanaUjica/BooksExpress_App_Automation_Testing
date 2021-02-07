package examProject.features.search;

import examProject.steps.serenity.EndUserSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Issue;
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

    @Issue("invalid login")
    @Test
    public void login_user_with_invalid_password() {

        steps.go_to_home_page();
        steps.fill_invalid_password_login(System.getProperty("username"), "1234abc");
        steps.verify_error_message_for_invalid_password("Parola este incorectă pentru acest cont");
    }

    @Issue("valid login")
    @Test
    public void login_user_with_valid_credentials() {

        steps.go_to_home_page();
        steps.verify_valid_credentials_login(System.getProperty("username"),  System.getProperty("password"), "Log out");
    }

    @Issue("logout")
    @Test
    public void logout() {

        steps.go_to_home_page();
        steps.verify_logout(System.getProperty("username"),  System.getProperty("password"), "Intră în cont");
    }

    @Issue("add book to wishlist")
    @Test
    public void add_book_to_wishlist() {

        steps.go_to_home_page();
        steps.add_credentials_and_login(System.getProperty("username"),  System.getProperty("password"));
        steps.search_book_by_keyword("JavaScript – The Definitive Guide, 7e", webDriver);
        steps.add_book_to_wishlist();
        steps.verify_if_book_is_added_to_wishlist("1. JavaScript – The Definitive Guide, 7e");
    }

    @Issue("add book to cart")
    @Test
    public void add_book_to_cart() {

        steps.go_to_home_page();
        steps.add_credentials_and_login(System.getProperty("username"),  System.getProperty("password"));
        steps.search_book_by_keyword("JavaScript – The Definitive Guide, 7e", webDriver);
        steps.add_book_to_wishlist();
        steps.add_book_to_cart();
        steps.verify_if_book_is_added_to_cart("JavaScript – The Definitive Guide, 7e");
    }
}
