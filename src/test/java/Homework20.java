import com.sun.source.tree.AssertTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
public class Homework20 extends BaseTest {
    @Test()
    public void deletePlaylistExplicitWaits (){
        String deletedPlaylistMsg = "Deleted playlist";

        provideEmail ("myakobov@gbmc.org");
        providePassword ("te$t$tudent");
        clickSubmit ();
        openPlaylist ();
        deletePlaylistButton ();
        Assert.assertTrue (getDeletedPlaylistMsg().contains(deletedPlaylistMsg));
    }
    public void openPlaylist (){
        WebElement openPlaylist = wait.until(ExpectedConditions.elementToBeClickable (By.xpath ("//section[@id='playlists'] //a[contains(text(),'Mara2023')]")));
        //WebElement openPlaylist = driver.findElement (By.xpath ("//section[@id='playlists'] //a[contains(text(), 'Mara2023')]"));
        openPlaylist.click ();
    }
    public void deletePlaylistButton (){
        WebElement deletePlaylistButton = wait.until(ExpectedConditions.elementToBeClickable (By.cssSelector ("button.del.btn-delete-playlist")));
        //WebElement deletePlaylistButton = driver.findElement (By.cssSelector ("button.del.btn-delete-playlist"));
        deletePlaylistButton.click ();
    }

    public String getDeletedPlaylistMsg() {
        WebElement notificationMsg = driver.findElement (By.cssSelector ("div.success.show"));
        return notificationMsg.getText ();
    }
}

//(By.xpath ("//section[@id='playlists'] //a[contains(text(), 'Mara2023')]")));
