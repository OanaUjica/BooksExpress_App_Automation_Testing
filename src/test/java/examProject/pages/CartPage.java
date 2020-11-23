package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    @FindBy(xpath="//*[@id=\"cart-items\"]/li/div[1]/div/h4/a")
    private WebElementFacade bookAddedToCart;

    public boolean verify_if_book_is_added_to_cart(String bookTitle) {

        return bookAddedToCart.getText().equalsIgnoreCase(bookTitle);
    }
}
