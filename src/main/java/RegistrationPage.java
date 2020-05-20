import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {
    @FindBy(css = "input#contact")
    private WebElement nameField;
    @FindBy(css = "input#email")
    private WebElement emailField;
    @FindBy(css = "label[for=subscribe")
    private WebElement suscribitionCheckBox;
    @FindBy(css = "input[name=password]")
    private WebElement passwordField;
    @FindBy(css = "a.ic__set")
    private WebElement hidePassword;
    @FindBy(css = "label[for=account_myPasswordEdit_3ID]")
    private WebElement generatePassword;
    @FindBy(css = "input#cellphone")
    private WebElement phoneField;
    @FindBy(css = "input[title=Зарегистрироваться]")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void setNameField(String name) {
        nameField.sendKeys(name);
    }

    @Step
    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }

    @Step
    public void subscribeCheck() {
        suscribitionCheckBox.click();
    }

    @Step
    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    @Step
    public void showPassword() {
        hidePassword.click();
    }

    @Step
    public void generatePassword() {
        generatePassword.click();
    }

    @Step
    public void setPhoneField(String phone) {
        phoneField.sendKeys(phone);
    }

    @Step
    public void sendRegistrationForm() {
        registerButton.click();
    }
}