import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Homework21 extends BaseTest {
    String newPlaylistName = "Updated playlist";

    @Test()
    public void renamePlaylist () {

        login ("myakobov@gbmc.org", "te$t$tudent");
        doubleClickFirstPlaylist ();
        enterNewPlaylistName ();
        Assert.assertTrue (isPlaylistUpdated ());
    }
    public void doubleClickFirstPlaylist () {
        wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector (".playlist:nth-child(3)")));
        WebElement firstPlaylist = driver.findElement (By.cssSelector (".playlist:nth-child(3)"));
        actions.doubleClick (firstPlaylist).perform ();
    }

    public void enterNewPlaylistName () {
        wait.until (ExpectedConditions.visibilityOfElementLocated (By.cssSelector ("[name='name']")));
        WebElement playlistInputField = driver.findElement (By.cssSelector ("[name='name']"));

        playlistInputField.sendKeys (Keys.chord (Keys.CONTROL, "A", Keys.BACK_SPACE));
        playlistInputField.sendKeys (newPlaylistName);
        playlistInputField.sendKeys (Keys.ENTER);
    }
    public boolean isPlaylistUpdated () {
        wait.until (ExpectedConditions.visibilityOfElementLocated (By.xpath ("//a[text()='" + newPlaylistName + "']")));
        WebElement updatedPlaylist = driver.findElement (By.xpath ("//a[text()='" + newPlaylistName + "']"));
        return updatedPlaylist.isDisplayed ();
    }
}



