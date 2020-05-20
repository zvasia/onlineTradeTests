import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    @FindBy(css = "a[data-handler=\"popup\"]")
    private WebElement authorizationPopUpButton;
    @FindBy(css = "input#ajax_login_popup_email")
    private WebElement emailField;
    @FindBy(css = "input#ajax_login_popup_pass")
    private WebElement passwordField;
    @FindBy(css = "label[for=autologin]")
    private WebElement rememberMeCheckBox;
    @FindBy(css = "input[name=\"submit\"]")
    private WebElement enterButton;
    @FindBy(css = ".formLines__registerLink")
    private WebElement registrationLink;

    public HomePage(WebDriver driver) {
        super(driver);
        getDriver();
    }

    @Step
    public void openAuthPopup() {
        authorizationPopUpButton.click();
    }

    @Step(value = "Ввод email")
    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step
    public void setRememberMeCheckBox() {
        rememberMeCheckBox.click();
    }

    @Step
    public void login() {
        enterButton.click();
    }

    public boolean authPopupAssert() {
        return enterButton.isDisplayed();
    }

    @Step
    public void goToRegistrationPage() {
        registrationLink.click();
    }
}
