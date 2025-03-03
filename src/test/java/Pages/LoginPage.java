
package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By submitButtonLocator = (By.cssSelector ("button[type = 'submit']"));
    By emailField = (By.cssSelector ("[type = 'email']"));
    By passwordField = (By.cssSelector ("[type = 'password']"));


    public LoginPage (WebDriver givenDriver){
        driver = givenDriver;
        wait  = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickSubmitBtn(){
        driver.findElement(submitButtonLocator).click();
    }

    public void provideEmail(String email){

        WebElement emailElement = driver.findElement(emailField);
        emailElement.click();
        emailElement.sendKeys(email);
    }
    public void providePassword (String password){
        WebElement passwordElement = driver.findElement(passwordField);
        passwordElement.click();
        passwordElement.sendKeys(password);
    }

    public void login(){
        provideEmail("myakobov@gbmc.org");
        providePassword("te$t$tudent");
        clickSubmitBtn ();
    }
}