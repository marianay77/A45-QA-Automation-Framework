import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
public class BaseTest {

    public static WebDriver driver = null;
    public static String url = null;


    @BeforeSuite
    static void setupClass () {
        WebDriverManager.chromedriver ().setup ();
    }


    @BeforeMethod
    @Parameters({"BaseURL"})

    public void launchBrowser (String BaseURL) {
        ChromeOptions options = new ChromeOptions ();
        options.addArguments ("--remote-allow-origins=*");

        driver = new ChromeDriver (options);
        driver.manage ().timeouts ().implicitlyWait (Duration.ofSeconds (10));

        url = BaseURL;
        driver.get(url);

    }

    @AfterMethod

    public void closeBrowser () {
        driver.quit ();
    }

    public static void navigateToPage () {
        driver.get (url);
    }

    public static void openLoginUrl () {
        driver.get ("https://bbb.testpro.io/");
    }

    public static void login (String email, String password) {
        provideEmail (email);
        providePassword (password);
        clickSubmit ();
    }
    public static void provideEmail (String email) {
        WebElement emailField = driver.findElement (By.cssSelector ("[type = 'email']"));
        emailField.click ();
        emailField.clear ();
        emailField.sendKeys (email);
    }

    public static void providePassword (String password) {
        WebElement passwordField = driver.findElement (By.cssSelector ("[type = 'password']"));
        passwordField.click ();
        passwordField.clear ();
        passwordField.sendKeys (password);
    }
    public static void clickSubmit () {
        WebElement clickSubmit = driver.findElement (By.cssSelector ("button[type = 'submit']"));
        clickSubmit.click ();
    }
    @DataProvider(name = "incorrectLoginData")
    public Object[][] getDataProvider(){
        return new Object[][]{
                {"invalid@email.com", "invalidPass"},
                {"anyEmail.com",""},
               {"", ""}


        };

    }



        }



