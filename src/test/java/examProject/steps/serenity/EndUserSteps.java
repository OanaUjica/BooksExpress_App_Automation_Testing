package examProject.steps.serenity;

import examProject.pages.LoginPage;
import net.thucydides.core.annotations.Step;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    LoginPage loginPage;

    @Step
    public void enters(String keyword) {
        loginPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        loginPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(loginPage.getDefinitions(), hasItem(containsString(definition)));
    }

    @Step
    public void is_the_home_page() {
        loginPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}