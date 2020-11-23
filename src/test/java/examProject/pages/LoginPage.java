package examProject.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.stream.Collectors;

public class LoginPage extends PageObject {

    @FindBy(id="username")
    private WebElementFacade inputUserName;

    @FindBy(id="email-button")
    private WebElementFacade emailButton;

    @FindBy(id="password")
    private WebElementFacade inputPassword;

    @FindBy(id="login-button")
    private WebElementFacade loginButton;

    @FindBy(id="login-message")
    private WebElementFacade invalidPasswordMessage;

    public void enter_userName(String name) {

        inputUserName.type(name);
    }

    public void click_emailButton() {

        emailButton.click();
    }

    public void enter_password(String password) {

        inputPassword.type(password);
    }

    public String error_message_for_invalid_password() {

        return invalidPasswordMessage.getValue();
    }

    public List<String> get_error_message() {
        WebElementFacade definitionList = find(By.tagName("div"));
        return definitionList.findElements(By.id("login-message")).stream()
                .map( element -> element.getText() )
                .collect(Collectors.toList());
    }

    public void click_login() {

        loginButton.click();
    }

}