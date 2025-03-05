import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

public class LogoutTest extends SetUpAndClose {

    @Test
    @DisplayName("Проверка правильности выхода, нажав кнопку \"Выход\" в своем аккаунте")
    @Description("Мы проверяем, чтобы после выхода из профиля отображалась страница авторизации - Вход")
    public void logoutSuccess() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

}
