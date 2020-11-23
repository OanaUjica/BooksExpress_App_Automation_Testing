package examProject.steps.serenity;

import examProject.pages.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    HeaderAllPages headerAllPages;
    LoginPage loginPage;
    SearchPage searchPage;
    BookPage bookPage;
    WishlistPage wishlistPage;
    CartPage cartPage;

    @Step
    public void go_to_home_page() {

        headerAllPages.open();
    }

    @Step
    public void add_valid_credentials_and_login(String email, String password) {

        headerAllPages.click_cont_button();
        headerAllPages.click_enterInCont_button();
        loginPage.enter_userName(email);
        loginPage.click_emailButton();
        loginPage.enter_password(password);
        loginPage.click_login();
    }

    @Step
    public void add_valid_credentials_login_and_then_logout(String email, String password) {

        headerAllPages.click_cont_button();
        headerAllPages.click_enterInCont_button();
        loginPage.enter_userName(email);
        loginPage.click_emailButton();
        loginPage.enter_password(password);
        loginPage.click_login();

        headerAllPages.click_cont_button();
        headerAllPages.click_logout();
    }

    @Step
    public void verify_error_message_for_invalid_password(String errorMessage) {

        assert(loginPage.error_message_for_invalid_password().endsWith(errorMessage));
        //assertThat(loginPage.error_message_for_invalid_password(), hasItem(containsString(errorMessage)));
    }

    @Step
    public void verify_message(String message) {
        assertThat(loginPage.get_error_message(), hasItem(containsString(message)));
    }

    @Step
    public void fill_invalid_password_login(String email, String password) {

        headerAllPages.click_cont_button();
        headerAllPages.click_enterInCont_button();
        loginPage.enter_userName(email);
        loginPage.click_emailButton();
        loginPage.enter_password(password);
        loginPage.click_login();
    }

    @Step
    public void verify_searched_book(String bookTitle) {

        assert(searchPage.get_searched_book().endsWith(bookTitle));
    }

    @Step
    public void search_book_by_keyword(String book, WebDriver webDriver) {

        headerAllPages.enter_searchInput(book);
        headerAllPages.click_searchButton();
        searchPage.click_searchSpecificBookButton(webDriver);
    }

    @Step
    public void verify_if_book_is_added_to_wishlist(String bookTitle) {

        assert(wishlistPage.verify_if_book_is_added_to_wishlist().endsWith(bookTitle));
    }

    @Step
    public void add_book_to_wishlist() {

        bookPage.click_bookAddedToWishlistButton();
        headerAllPages.click_mainPageButton();
        headerAllPages.click_listsButton();
        headerAllPages.click_wishlistPageButton();
    }

    @Step
    public void verify_if_book_is_added_to_cart(String bookTitle) {

        assertThat(bookTitle, cartPage.verify_if_book_is_added_to_cart(bookTitle));
    }

    @Step
    public void add_book_to_cart() {

        wishlistPage.click_addedBookToCartButton();
        headerAllPages.click_cartListButton();
        headerAllPages.click_showCartPageButton();
    }
}
