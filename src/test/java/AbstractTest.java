import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

abstract class AbstractTest {
    private final static String BASE_URL = "https://www.onlinetrade.ru/";
    protected static WebDriver driver;

    private WebDriver driverInit(String browserName) {
        if (browserName.equals("chrome")) {
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }


    @BeforeTest(description = "Driver setup and get to base URL")
    @Parameters("browserName")
    public void setUp(String browserName) {
        driver = driverInit(browserName);
        driver.get(BASE_URL);
    }


    @AfterTest(description = "Close browser")
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }


}
