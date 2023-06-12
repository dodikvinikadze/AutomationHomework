import PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static DataObject.LoginData.*;

public class LoginTest {
    WebDriver driver;

    @BeforeMethod(description = "setup browser before testing")
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void validLogin() throws InterruptedException {
        LoginPage home = new LoginPage(driver);
        home
                .UsernameInput(username)
                .PasswordInput(password)
                .clickOnLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
