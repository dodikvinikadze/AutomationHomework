package PageObject;

import DataObject.LoginData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static DataObject.LoginData.password;


public class LoginPage {
   WebDriver driver;



   public LoginPage(WebDriver driver) {
      this.driver = driver;
   }
   By usernameInput = By.id("user-name");
   By passwordInput = By.id("password");
   By loginButton = By.id("login-button");

   @Step("username input:{0}")
   public LoginPage UsernameInput(String username) {
      driver.findElement(usernameInput).sendKeys(LoginData.username);
      return this;
   }
   @Step("password input:{0}")
   public LoginPage PasswordInput(String password) {
      driver.findElement(passwordInput).sendKeys(LoginData.password);
      return this;
   }

   @Step("click on button")
   public LoginPage clickOnLoginButton() throws InterruptedException {
      driver.findElement(loginButton).click();
      Thread.sleep(5000);
      return this;
   }
}
