package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Epic("Модуль логтна интернет-магазина")
    @Feature("TMS-56")
    @Story("TNS-56.67")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Khrol Na Ser bla@gmail.com")
    @TmsLink("UrnSu")
    @Issue("3")
    @Description("Проверка входа в систему интернет-магазина")
    @Flaky
    @Test(description = "авторизация под верными данными")
    public void correctLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isDisplayed(), "");
        assertEquals("Products", productsPage.getTitle());
    }

    @DataProvider(name = "blabla")
    public Object[][] loginData() {
        return new Object[][]{
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "blabla")
    public void loginWrongData(String user, String pass, String errorMsg) {
        loginPage.open();
        loginPage.login(user, pass);
        assertEquals(loginPage.getErrorMessage(), errorMsg);
    }
}
