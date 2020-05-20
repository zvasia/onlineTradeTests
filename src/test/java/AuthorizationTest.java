import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyTestListener.class)
@Epic("Authorization from homePage")
public class AuthorizationTest extends AbstractTest {
    HomePage hp;

    @Test
    public void authorizationTest() {
        hp = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(), "Интернет-магазин ОНЛАЙН ТРЕЙД.РУ. Покупай всё онлайн!",
                "Заголовок страницы не соответствует требованиям");
        hp.openAuthPopup();
        hp.enterEmail("email@adfas.ru");
        hp.enterPassword("12345");
        hp.login();
        Assert.assertEquals(driver.getTitle(), "Личный кабинет - Главная - Интернет-магазин ОНЛАЙН ТРЕЙД.РУ",
                "Заголовок страницы не соответствует требованиям");
    }
}
