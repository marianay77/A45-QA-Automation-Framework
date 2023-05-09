import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
public class Homework19 extends BaseTest {
    @Test()
    public void deletePlaylist () throws InterruptedException {

        String deletedPlaylistMsg = "Deleted playlist";
        login ("myakobov@gbmc.org", "te$t$tudent");
        Thread.sleep (2000);
        openPlaylist ();
        deletePlaylistButton ();
        getDeletedPlaylistMsg ();
        Assert.assertTrue (getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
    public void openPlaylist () throws InterruptedException {
        WebElement openPlaylist = driver.findElement (By.xpath ("//section[@id='playlists'] //a[contains(text(), 'Mara2023')]"));
        openPlaylist.click ();
        Thread.sleep (2000);
    }
        public void deletePlaylistButton ()throws InterruptedException {
            WebElement deletePlaylistButton = driver.findElement (By.cssSelector ("button.del.btn-delete-playlist"));
            deletePlaylistButton.click ();
            Thread.sleep (2000);
        }
            public String getDeletedPlaylistMsg() {
            WebElement getDeletedPlaylistMsg = driver.findElement (By.cssSelector ("div.success.show"));
            return getDeletedPlaylistMsg.getText ();
        }
    }

