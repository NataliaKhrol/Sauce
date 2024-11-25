package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isDispl(), "");
      //  assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void incorrectLoginCheck() {
        loginPage.open();
        loginPage.login("standard_userss", "secret_sauce");
        assertTrue(driver.findElement(By.xpath("//*[text()='Products']")).isDisplayed());
        assertEquals(driver.findElement(By.xpath("//*[@class='title']")).getText(), "Products");
    }

    @Test
    public void emptyPasswordInputCheck() {
        loginPage.open();
        loginPage.login("standard_user", " ");
        assertEquals(driver.findElement(By.xpath("//h3")).getText(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
