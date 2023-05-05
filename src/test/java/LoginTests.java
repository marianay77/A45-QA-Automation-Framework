import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
   /* @Test
    public static void LoginEmptyEmailPasswordTest() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }*/
    @Test(dataProvider = "incorrectLoginData")
    public static void loginEmptyEmailPasswordTest(String email, String password){
        //navigateToPage ();
        provideEmail (email);
        providePassword (password);
        clickSubmit ();
       Assert.assertEquals (driver.getCurrentUrl (), url);

    }

    /*@Test
    public void LoginValidEmailPasswordTest(){

        navigateToPage ();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit ();
        avatarIsDisplayed();


    }*/

}
