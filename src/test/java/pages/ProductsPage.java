package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_TO_CART_PATTERN =
            "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    private final By title = By.cssSelector("[class=title]");
    private final By title2 = By.xpath("//*[text()='Products']");

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public void addToCart(String product) {
        By addToCart = By.xpath(String.format(ADD_TO_CART_PATTERN, product));
        driver.findElement(addToCart).click();
    }

    public boolean isDispl() {
        driver.findElement(title2).isDisplayed();
        return true;
    }
}