package hu.progmatic.pages;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AppointmentPage extends DriverBaseTest {
    WebDriver driver;
    WebDriverWait wait;

    By usernameBy = By.id("txt-username");
    By passwordBy = By.id("txt-password");
    By loginButtonClickBy = By.id("btn-login");
    By readmissionBy = By.id("chk_hospotal_readmission");
    By HealthcareBy = By.id("radio_program_medicaid");
    By DateBy = By.id("txt_visit_date");
    By bookingButtonBy = By.id("btn-book-appointment");
    By writeCommentBy = By.id("txt_comment");

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void Login() throws InterruptedException{
        WebElement username = driver.findElement(usernameBy);
        WebElement password = driver.findElement(passwordBy);

        username.sendKeys("John Doe");
        password.sendKeys("ThisIsNotAPassword");

        WebElement LoginButton = driver.findElement(loginButtonClickBy);
        LoginButton.click();
        Thread.sleep(2000);
        System.out.println("Login ok!");
    }

    public void AppointmentTest()  {
        //Apply for hospital readmission-re kattint
        WebElement readmission = driver.findElement(readmissionBy);
        readmission.click();
        //Megkerkesi és kiválasztja a Medicaid-et
        WebElement Healthcare = driver.findElement(HealthcareBy);
        Healthcare.click();
        //Megkeresi és ad egy dátumot a Visit Date-nél
        WebElement Date = driver.findElement(DateBy);
        Date.sendKeys("25/03/2023");
        //Megkeresi és Comment-be bele ír
        WebElement writeComment = driver.findElement(writeCommentBy);
        writeComment.sendKeys("Whatever");
        //Megkeresi ás kattint a gombra
        WebElement bookingButton = driver.findElement(bookingButtonBy);
        bookingButton.click();
        //Ellenőrzés
        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");
        System.out.println("Booking ok!");
    }
}
