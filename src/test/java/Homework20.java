import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
public class Homework20 extends BaseTest {
    @Test()
    public void deletePlaylistExplicitWaits (){

        //GIVEN

        String deletedPlaylistMsg = "Deleted Playlist";

        provideEmail ("demo@class.com");
        providePassword ("te$t$tudent");
        clickSubmit ();

        //WHEN

        openPlaylist ();
        deletePlaylistButton ();
        getDeletedPlaylistMsg ();

        //THEN

        Assert.assertTrue (getDeletedPlaylistMsg().contains("Deleted Playliist"));

    }
    public void openPlaylist (){
        WebElement openPlaylist = wait.until(ExpectedConditions.elementToBeClickable (By.xpath ("//section[@id='playlists'] //a[contains(text(), 'Mara2023')]")));
        //WebElement openPlaylist = driver.findElement (By.xpath ("//section[@id='playlists'] //a[contains(text(), 'Mara2023')]"));
        openPlaylist.click ();

    }
    public void deletePlaylistButton (){
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable (By.cssSelector ("button.del.btn-delete-playlist")));
        //WebElement deletePlaylistButton = driver.findElement (By.cssSelector ("button.del.btn-delete-playlist"));
        deletePlaylistButton.click ();

    }


    public String getDeletedPlaylistMsg() {
        WebElement getDeletedPlaylistMsg = wait.until(ExpectedConditions.elementToBeClickable (By.cssSelector ("div.success.show")));
        //WebElement getDeletedPlaylistMsg = driver.findElement (By.cssSelector ("div.success.show"));
        return getDeletedPlaylistMsg.getText ();
    }
}


