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
    private WebElementFacade contDropdown;

    @FindBy(id="LoginButton1")
    private WebElementFacade loginButton;

    @FindBy(name="username")
    private WebElementFacade inputUserName;

    @FindBy(name="password")
    private WebElementFacade inputPassword;

}