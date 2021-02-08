package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.Arrays;
import java.util.List;

public class CartPage extends PageObject {

    @FindBy(id="cart-items")
    private WebElementFacade listOfBooksAddedToCart;

    public List<String> get_cart_books() {

        return Arrays.asList(this.listOfBooksAddedToCart.getText().split("\n"));
    }
}
