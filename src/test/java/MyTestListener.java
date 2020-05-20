import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class MyTestListener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        saveScreenshot();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) AbstractTest.driver).getScreenshotAs(OutputType.BYTES);
    }
}
