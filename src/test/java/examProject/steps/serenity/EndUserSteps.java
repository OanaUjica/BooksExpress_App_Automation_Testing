package examProject.steps.serenity;

import examProject.pages.LoginPage;
import examProject.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    LoginPage loginPage;
    //SearchPage searchPage;

    @Step
    public void go_to_home_page() {

        loginPage.open();
    }

    @Step
    public void fill_data_and_login(String email, String password, String book, WebDriver webDriver) {

        loginPage.click_cont_button();
        loginPage.click_enterInCont_button();
        loginPage.enter_userName(email);
        loginPage.click_emailButton();
        loginPage.enter_password(password);
        loginPage.click_login();

        loginPage.enter_searchInput(book);
        loginPage.click_searchButton();
        loginPage.click_searchSpecificBookButton(webDriver);
        loginPage.searched_book_is_available(webDriver);

        loginPage.click_bookAddedToWishlistButton();
        loginPage.click_mainPageButton();
        loginPage.click_listsButton();
        loginPage.click_wishlistPageButton(webDriver);
        loginPage.book_is_added_to_wishlist(webDriver);

        loginPage.click_addedBookToCartButton();
        loginPage.click_cartListButton();
        loginPage.click_showCartPageButton();
        loginPage.book_is_added_to_cart(webDriver);

        loginPage.click_cont_button();
        loginPage.click_logout();
    }

//    public void find_book(WebDriver webdriver) {
//
//
//    }

//    public void search_book(String book) {
//
//
//    }
}
