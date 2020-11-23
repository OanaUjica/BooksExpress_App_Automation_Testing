package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class WishlistPage extends PageObject {

    @FindBy(xpath="/html/body/div[7]/div/section/ul/li/div/div/div/h4/a[1]")
    private WebElementFacade bookAddedToWishlist;

    @FindBy(xpath="//*[@class=\"button alt add2cart\"]")
    private WebElementFacade addInCartButton;

    public void click_addedBookToCartButton() {

        addInCartButton.click();
    }

    public String verify_if_book_is_added_to_wishlist() {

        return bookAddedToWishlist.getValue();
    }
}
