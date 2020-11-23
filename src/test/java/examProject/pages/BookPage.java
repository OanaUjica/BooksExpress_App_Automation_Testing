package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class BookPage extends PageObject {

    @FindBy(xpath="/html/body/div[7]/div/div/div[2]/div/section[2]/section/div/div[3]/div/a[1]")
    private WebElementFacade bookAddedToWishlistButton;

    public void click_bookAddedToWishlistButton() {

        bookAddedToWishlistButton.click();
    }
}
