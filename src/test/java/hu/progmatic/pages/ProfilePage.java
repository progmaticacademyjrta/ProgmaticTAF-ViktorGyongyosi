package hu.progmatic.pages;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage extends DriverBaseTest {

    WebDriver driver;
    WebDriverWait wait;

    By MenuButtonBy = By.id("menu-toggle");
    By ProfileButtonBy = By.linkText("Profile");

    By LogoutButtonBy = By.linkText("Logout");

    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void ProfilePageButtonTest(){
        //Megkeresi és rákattint a felső sávban lévő menü opcioót
        WebElement MenuButton = driver.findElement(MenuButtonBy);
        MenuButton.click();
        //Megkeresi és rákattint a profile gombra a menű opción
        WebElement ProfileButton = driver.findElement(ProfileButtonBy);
        ProfileButton.click();
        //Megkeresi a Logout gombot
        WebElement LogoutButton = driver.findElement(LogoutButtonBy);
        //Ellenőriz
        Assert.assertEquals(LogoutButton.getText(),"Logout");

        System.out.println("Profile page ok!");
    }
}
