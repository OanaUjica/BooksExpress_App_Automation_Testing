package examProject.steps.serenity;

import examProject.pages.LoginPage;
import examProject.pages.SearchPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    LoginPage loginPage;
    SearchPage searchPage;

    @Step
    public void go_to_home_page() {

        loginPage.open();
    }

    @Step
    public void fill_data_and_login(String email, String password, String book) {

        loginPage.click_cont_button();
        loginPage.click_enterInCont_button();
        loginPage.enter_userName(email);
        loginPage.click_emailButton();
        loginPage.enter_password(password);
        loginPage.click_login();
        //loginPage.click_cont_button();
        //loginPage.click_logout();
        searchPage.enter_searchInput(book);
        searchPage.click_searchButton();
    }

//    public void search_book(String book) {
//
//
//    }
}
