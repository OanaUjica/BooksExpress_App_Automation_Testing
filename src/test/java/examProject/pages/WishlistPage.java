package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import java.util.Arrays;
import java.util.List;

public class WishlistPage extends PageObject {

    @FindBy(xpath="/html/body/div[7]/div/section/ul/li/div/div/div/h4/a[1]")
    private WebElementFacade bookAddedToWishlist;

    @FindBy(xpath="//*[@class=\"button alt add2cart\"]")
    private WebElementFacade addInCartButton;

    @FindBy(id="list-items")
    private WebElementFacade listOfBooks;

    public List<String> get_wishlist_books() {

        return Arrays.asList(this.listOfBooks.getText().split("\n"));

    }

    public void click_addedBookToCartButton() {

        addInCartButton.click();
    }

    public boolean verify_if_book_is_added_to_wishlist(String bookTitle) {

        return bookAddedToWishlist.getText().equalsIgnoreCase(bookTitle);
    }
}
