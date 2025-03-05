import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

public class SwitchTest extends SetUpAndClose {

    @Test
    @DisplayName("Проверка перехода осуществляется нажатием на Личный кабинет")
    @Description("Проверка, что мы попадаем на страницу авторизации, где отображается надпись Войти")
    public void checkClickOnPersonalAccButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    @Description("Проверка перехода из личного кабинета на главную страницу осуществляется нажатием кнопки Конструктор")
    public void switchFromProfileByClickDesignerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип")
    @Description("Проверьте переход из личного кабинета на главную страницу, нажав на логотип")
    public void switchFromProfileByClickLogoBurger() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

}
