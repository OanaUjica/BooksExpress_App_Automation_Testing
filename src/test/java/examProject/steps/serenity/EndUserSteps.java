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
    public void add_credentials_and_login(String email, String password) {

        headerAllPages.click_cont_button();
        headerAllPages.click_enterInCont_button();
        loginPage.enter_userName(email);
        loginPage.click_emailButton();
        loginPage.enter_password(password);
        loginPage.click_login();
    }

    @Step
    public void verify_valid_credentials_login(String email, String password, String textToVerifyUserIsLoggedIn) {

        add_credentials_and_login(email, password);

        headerAllPages.click_cont_button();

        assertThat(textToVerifyUserIsLoggedIn, headerAllPages.verify_logout_button_for_login(textToVerifyUserIsLoggedIn));
    }

    @Step
    public void verify_logout(String email, String password, String textToVerifyUserIsLogout) {

        add_credentials_and_login(email, password);

        headerAllPages.click_cont_button();
        headerAllPages.click_logout();

        headerAllPages.click_cont_button();

        assertThat(textToVerifyUserIsLogout, headerAllPages.verify_enterInCont_button_for_logout(textToVerifyUserIsLogout));
    }

    @Step
    public void fill_invalid_password_login(String email, String password) {

        add_credentials_and_login(email, password);
    }

    @Step
    public void verify_error_message_for_invalid_password(String errorMessage) {

        assertThat(errorMessage, loginPage.error_message_for_invalid_password(errorMessage));
    }

    @Step
    public void search_book(String book) {

        headerAllPages.enter_searchInput(book);
        headerAllPages.click_searchButton();
    }

    @Step
    public void verify_searched_book(String bookTitle) {

        assertThat(searchPage.get_searched_book(), hasItem(containsString(bookTitle)));
    }

    @Step
    public void search_book_by_keywords(String book, WebDriver webDriver) {

        headerAllPages.enter_searchInput(book);
        headerAllPages.click_searchButton();
        searchPage.click_searchSpecificBookButton(webDriver, book);
    }

    @Step
    public void add_book_to_wishlist() {

        bookPage.click_bookAddedToWishlistButton();
        headerAllPages.click_mainPageButton();
        headerAllPages.click_listsButton();
        headerAllPages.click_wishlistPageButton();
    }

    @Step
    public void verify_if_book_is_added_to_wishlist(String bookTitle) {

        assertThat(wishlistPage.get_wishlist_books(), hasItem(containsString(bookTitle)));
    }

    @Step
    public void add_book_to_cart() {

        wishlistPage.click_addedBookToCartButton();
        headerAllPages.click_cartListButton();
        headerAllPages.click_showCartPageButton();
    }

    @Step
    public void verify_if_book_is_added_to_cart(String bookTitle) {

        assertThat(cartPage.get_cart_books(), hasItem(containsString(bookTitle)));
    }
}
