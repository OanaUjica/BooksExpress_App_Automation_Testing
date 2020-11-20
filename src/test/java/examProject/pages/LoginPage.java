package examProject.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.pages.WebElementFacade;
import java.time.Duration;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
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

    @FindBy(id="search")
    private WebElementFacade searchInput;

    @FindBy(xpath="/html/body/header/div/form/button[1]")
    private WebElementFacade searchButton;

    //@FindBy(xpath="/html/body/div[7]/section/div/article[6]/header/h2/a[1]")
    @FindBy(xpath="//*[@title=\"JavaScript – The Definitive Guide, 7e\"]")
    private WebElementFacade searchSpecificBookButton;

    @FindBy(xpath="/html/body/div[7]/div/div/div[2]/div/section[2]/section/div/div[3]/div/a[1]")
    private WebElementFacade bookAddedToWishlistButton;

    @FindBy(css=".growl-close")
    private WebElementFacade closeButton;

    //@FindBy(id="show-lists")
    @FindBy(xpath="//*[@title=\"Books Express este o librarie online cu carti din toata lumea\"]")
    private WebElementFacade mainPageButton;

    @FindBy(id="show-lists")
    private WebElementFacade listsButton;

    @FindBy(xpath="/html/body/div[6]/ul/li/a")
    private WebElementFacade wishlistPageButton;

    @FindBy(xpath="/html/body/div/ul/li/a[1]")
    private WebElementFacade logoutButton;

    @FindBy(xpath="//*[@class=\"button alt add2cart\"]")
    private WebElementFacade addInCartButton;

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

    public void searched_book_is_available(@NotNull WebDriver webDriver) {

        List<WebElement> bookTitle = webDriver.findElements(By.xpath("//*[contains(text(),'JavaScript – The Definitive Guide, 7e')]"));
        String availableTitle = bookTitle.size() >= 1 ? "The book is available" : "The book is not available";
        System.out.println(availableTitle);
    }

    public void book_is_added_to_wishlist(@NotNull WebDriver webDriver) {

        List<WebElement> bookTitle = webDriver.findElements(By.xpath("//*[contains(text(),'JavaScript – The Definitive Guide, 7e')]"));
        String availableTitle = bookTitle.size() >= 1 ? "The book is rendered in the wishlist" : "The book is not rendered in the wishlist";
        System.out.println(availableTitle);
    }

    public void book_is_added_to_cart(@NotNull WebDriver webDriver) {

        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JavaScript – The Definitive Guide, 7e")));

        List<WebElement> bookTitle = webDriver.findElements(By.xpath("//*[contains(text(),'JavaScript – The Definitive Guide, 7e')]"));
        String availableTitle = bookTitle.size() >= 1 ? "The book is rendered in the cart" : "The book is not rendered in the cart";
        System.out.println(availableTitle);
    }

//    public boolean isPageOpened() {
//        //Assertion
//        return title.getText().toString().contains("Apply to join our network as a developer");
//    }

    public void click_searchSpecificBookButton(WebDriver webDriver) {

//        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        WebElement anchor = wait.until(ExpectedConditions.elementToBeClickable(By.id(itemId)));
//        anchor.click();
        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JavaScript – The Definitive Guide, 7e")));

        searchSpecificBookButton.click();
    }

    public void click_bookAddedToWishlistButton() {

        bookAddedToWishlistButton.click();
    }

    public void click_mainPageButton() {

//        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
//                .withTimeout(Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("show-lists")));
        mainPageButton.click();
    }

    public void click_listsButton() {

        listsButton.click();
    }

    public void click_wishlistPageButton(WebDriver webDriver) {

//        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
//                .withTimeout(Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("   Wish list")));
        wishlistPageButton.click();
    }

    public void click_addedBookToCartButton() {

        addInCartButton.click();
    }

    public void click_cartListButton() {

        cartListButton.click();
    }

    public void click_showCartPageButton() {

        showCartPageButton.click();
    }

//    public void click_closeButton(WebDriver webDriver) {
//
//        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
//                .withTimeout(Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".growl-close")));
//        closeButton.click();
//    }
}