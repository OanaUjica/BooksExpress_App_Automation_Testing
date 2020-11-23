package examProject.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public class SearchPage extends PageObject {

    @FindBy(xpath="//*[@title=\"JavaScript – The Definitive Guide, 7e\"]")
    private WebElementFacade searchSpecificBookAnchor;

    public void click_searchSpecificBookButton(WebDriver webDriver) {

        FluentWait<WebDriver> wait = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("JavaScript – The Definitive Guide, 7e")));

        searchSpecificBookAnchor.click();
    }

    public String get_searched_book() {

        return searchSpecificBookAnchor.getText();
    }
}
