import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
public class Homework19 extends BaseTest {
    @Test()
    public void deletePlaylist () throws InterruptedException {

        //GIVEN

        String deletedPlaylistMsg = "Deleted Playlist";

        login ("demo@class.com", "te$t$tudent");
        Thread.sleep (2000);
        
        //WHEN

        openPlaylist ();
        deletePlaylistButton ();
        getDeletedPlaylistMsg ();

        //THEN

        Assert.assertTrue (getDeletedPlaylistMsg().contains("Deleted Playliist"));

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

