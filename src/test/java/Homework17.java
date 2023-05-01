import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist () throws InterruptedException {

        navigateToPage ();
        provideEmail ("demo@testpro.io");
        providePassword ("te$t$tudent");
        clickSubmit ();
        Thread.sleep (2000);
    }

        /*searchField.sendKeys("Reactor");
        clickViewAll();
        chooseSong();
        addToButton();
        Thread.sleep(2000);*/


    public void searchField (String reactor) throws InterruptedException {
        WebElement searchField = driver.findElement (By.cssSelector ("div.results h1>button"));
        searchField.sendKeys ("Reactor");
        Thread.sleep (2000);

    }

    public void clickViewAll () throws InterruptedException {
        WebElement clickViewAll = driver.findElement (By.cssSelector ("div.item-container"));
        clickViewAll.click ();
        Thread.sleep (2000);
    }

    public void chooseSong () throws InterruptedException {
        WebElement chooseSong = driver.findElement (By.cssSelector ("section#songResultsWrapper td.title"));
        chooseSong.click ();
        Thread.sleep (2000);
    }

    public void addToButton () throws InterruptedException {
        WebElement addToButton = driver.findElement (By.cssSelector ("section#songResultsWrapper  button.btn-add-to"));
        addToButton.click ();
        Thread.sleep (2000);

    }

    public void choosePlaylist () throws InterruptedException {
        WebElement choosePlaylist = driver.findElement (By.xpath ("//section[@id='songResultsWrapper'] //li[contains(text(),'Mara2023')]"));
        choosePlaylist.click ();
        Thread.sleep (2000);



            WebElement notifMsg = driver.findElement (By.cssSelector ("div.success.show"));
            Assert.assertTrue (notifMsg.getText ().contains ("Added 1 song into Mara2023"));




    }

}











