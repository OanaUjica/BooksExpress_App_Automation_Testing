package examProject.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;

@DefaultUrl("https://www.books-express.ro/")
public class LoginPage extends PageObject {

    @FindBy(id="show-user")
    private WebElementFacade contDropdownButton;

    @FindBy(css=".show-no-user")
    private WebElementFacade enterInContButton;

    @FindBy(id="username")
    private WebElementFacade inputUserName;

    @FindBy(id="email-button")
    private WebElementFacade emailButton;

    @FindBy(id="password")
    private WebElementFacade inputPassword;

    @FindBy(id="login-button")
    private WebElementFacade loginButton;

    @FindBy(css=".show-user")
    private WebElementFacade logoutButton;

    public void click_cont_button() {

        contDropdownButton.click();
    }

    public void click_enterInCont_button() {

        enterInContButton.click();
    }

    public void enter_userName(String name) {

        inputUserName.type(name);
    }

    public void click_emailButton() {

        emailButton.click();
    }

    public void enter_password(String password) {

        inputPassword.type(password);
    }

    public void click_login() {

        loginButton.click();
    }

    public void click_logout() {

        logoutButton.click();
    }
}