import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.LoginPage;

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
    public static void loginEmptyEmailPasswordTest (String email, String password) {
        navigateToPage ();
        provideEmail (email);
        providePassword (password);
        clickSubmit ();
        Assert.assertEquals (driver.getCurrentUrl (), url);
    }
    @Test
    public void LoginValidEmailPasswordTestPOM () {

        LoginPage loginPage = new LoginPage (driver);
        HomePage homePage = new HomePage (driver);

        loginPage.login ();
        Assert.assertTrue (homePage.getUserAvatar ().isDisplayed ());
    }
}
        //loginPage.provideEmail("myakobov@gbcm.org");
        //loginPage.providePassword("te$t$tudent");
        //loginPage.clickSubmitBtn ();
//WebElement avatarIcon  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssLocator("img.avatar")));
//Assert.assertTrue(avatarIcon.isDisplayed());

