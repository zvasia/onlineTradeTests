import io.qameta.allure.Epic;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(MyTestListener.class)
@Epic("Registration from homePage")
public class RegistrationTest extends AbstractTest {
    HomePage hp;
    RegistrationPage rp;

    @Test
    public void registerUserTest() {
        hp = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(), "Интернет-магазин ОНЛАЙН ТРЕЙД.РУ. Покупай всё онлайн!",
                "Заголовок страницы не соответствует требованиям");
        hp.openAuthPopup();
        Assert.assertTrue(hp.authPopupAssert(), "Попап авторизации не открылся");
        hp.goToRegistrationPage();
        rp = new RegistrationPage(driver);
        Assert.assertEquals(driver.getTitle(), "Личный кабинет - Регистрация - Интернет-магазин ОНЛАЙН ТРЕЙД.РУ",
                "Заголовок страницы не соответствует требованиям");
        rp.setNameField("Тестовое Имя");
        rp.setEmailField("test@email.com");
        rp.subscribeCheck();
        rp.showPassword();
        rp.generatePassword();
        rp.setPhoneField("+79008996754");
        rp.sendRegistrationForm();
        Assert.assertEquals(driver.getTitle(), "Личный кабинет - Главная - Интернет-магазин ОНЛАЙН ТРЕЙД.РУ",
                "Заголовок страницы не соответствует требованиям");
    }
}
