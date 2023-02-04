package hu.progmatic.pages;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends DriverBaseTest {

    WebDriver driver;
    WebDriverWait wait;
    By usernameLoginFillBy = By.id("txt-username");
    By passwordLoginByFillBy = By.id("txt-password");
    By loginButtonClickBy = By.id("btn-login");
    By errorMessageBy = By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void LoginTest(){
        //Megekereso a username kitoltendő mezőt
        WebElement usernameLoginFill = driver.findElement(usernameLoginFillBy);
        //Megekereso a password kitoltendő mezőt
        WebElement passwordLoginFill = driver.findElement(passwordLoginByFillBy);
        //Beír egy rossz username-t
        usernameLoginFill.sendKeys("UserName");
        //Beír egy rossz password-ot
        passwordLoginFill.sendKeys("WrongPassword");
        //Kattint a login buttonra az oldalon
        WebElement LoginButtonClick = driver.findElement(loginButtonClickBy);
        LoginButtonClick.click();
        //Megkereso a hibaüzenetet, ami a rossz adatok miatt feljön
        WebElement errorMessageSearch = driver.findElement(errorMessageBy);
        Assert.assertEquals(errorMessageSearch.getText(), "Login failed! Please ensure the username and password are valid.");
        //Ellenőrzés
        System.out.println("Failed login ok!");
    }

}
