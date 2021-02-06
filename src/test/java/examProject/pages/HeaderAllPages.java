package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.books-express.ro/")
public class HeaderAllPages extends PageObject {

    @FindBy(id="show-user")
    private WebElementFacade contDropdownButton;

    @FindBy(css=".show-no-user")
    private WebElementFacade enterInContButton;

    @FindBy(id="search")
    private WebElementFacade searchInput;

    @FindBy(xpath="/html/body/header/div/form/button[1]")
    private WebElementFacade searchButton;

    @FindBy(xpath="//*[@title=\"Books Express este o librarie online cu carti din toata lumea\"]")
    private WebElementFacade mainPageButton;

    @FindBy(id="show-lists")
    private WebElementFacade listsButton;

    @FindBy(xpath="/html/body/div[6]/ul/li/a")
    private WebElementFacade wishlistPageButton;

    //@FindBy(xpath="/html/body/div/ul/li/a[1]")
    //@FindBy(css = "a[href=\"/logout\"]")
    @FindBy(xpath="//*[@id=\"user-data\"]/ul/li[8]/a")
    private WebElementFacade logoutButton;

    //@FindBy(css = "a[href=\"https://www.books-express.ro/login\"]")
    @FindBy(xpath="//*[@id=\"user-data\"]/ul/li[1]/a")
    private WebElementFacade intraInContText;

    @FindBy(xpath="//*[@id=\"user-data\"]/ul/li[8]/a")
    private WebElementFacade logoutText;

    @FindBy(id="show-cart")
    private WebElementFacade cartListButton;

    @FindBy(xpath="//*[@class=\"button special full\"]")
    private WebElementFacade showCartPageButton;

    public void enter_searchInput(String bookName) {

        searchInput.type(bookName);
    }

    public void click_searchButton() {

        searchButton.click();
    }

    public void click_cont_button() {

        contDropdownButton.click();
    }

    public void click_enterInCont_button() {

        enterInContButton.click();
    }

    public void click_logout() {

        logoutButton.click();
    }

    public boolean verify_enterInCont_button_for_logout(String textToVerifyUserIsLogout) {

        return intraInContText.getText().equalsIgnoreCase(textToVerifyUserIsLogout);
    }

    public boolean verify_logout_button_for_login(String textToVerifyUserIsLoggedIn) {

        return logoutText.getText().equalsIgnoreCase(textToVerifyUserIsLoggedIn);
    }

    public void click_mainPageButton() {

        mainPageButton.click();
    }

    public void click_listsButton() {

        listsButton.click();
    }

    public void click_wishlistPageButton() {

        wishlistPageButton.click();
    }

    public void click_cartListButton() {

        cartListButton.click();
    }

    public void click_showCartPageButton() {

        showCartPageButton.click();
    }
}
