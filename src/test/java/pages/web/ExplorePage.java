package pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ExplorePage {

    private final WebDriver driver;

    private static final By SEARCH_FIELD     = By.cssSelector(".custom-input-search");
    private static final By EXPLORE_BUTTON   = By.cssSelector(".ExploreSaham_bit-explore-button__XEn5W");
    private static final By RESULT_CONTAINER = By.cssSelector(".ExploreSaham_watchlist-item-full__r66lZ");
    private static final By RESULT_ITEMS     = By.cssSelector(".ExploreSaham_stock-details-item__d5BDU");
    private static final By EMPTY_STATE      = By.cssSelector(".SearchEmptyState_search-content-empty__kcFoj");

    public ExplorePage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterSearchKeyword(String value) {
        WebElement field = driver.findElement(SEARCH_FIELD);
        field.clear();
        field.sendKeys(value);
    }

    public void clickExploreButton() {
        driver.findElement(EXPLORE_BUTTON).click();
    }

    public WebElement getResultContainer() {
        return driver.findElement(RESULT_CONTAINER);
    }

    public List<WebElement> getResultItems() {
        return driver.findElements(RESULT_ITEMS);
    }

    public WebElement getEmptyState() {
        return driver.findElement(EMPTY_STATE);
    }
}
