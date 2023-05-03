import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test
    public void playSong () throws InterruptedException {
        navigateToPage ();
        provideEmail ("demo@class.com");
        providePassword ("te$t$tudent");
        clickSubmit ();
        Thread.sleep (2000);
    }

    public void playButton () throws InterruptedException {
        WebElement playButton = driver.findElement (By.cssSelector (".album-thumb-wrapper .fa.fa-play"));
        WebElement soundBarPlay = driver.findElement (By.cssSelector ("div.wrapper"));
        Thread.sleep (2000);
        playButton.click ();
        Assert.assertTrue (soundBarPlay.isDisplayed ());
    }
}
