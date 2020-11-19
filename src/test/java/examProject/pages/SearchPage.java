package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage {

    @FindBy(id="search")
    private WebElementFacade searchInput;

    @FindBy(css=".button special icon fa-search right")
    private WebElementFacade searchButton;

    public void enter_searchInput(String bookName) {

        searchInput.type(bookName);
    }

    public void click_searchButton() {

        searchButton.click();
    }
}
