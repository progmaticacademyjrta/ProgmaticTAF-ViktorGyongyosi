package hu.progmatic.exampletests;

import hu.progmatic.driverfactory.DriverBaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TechlisticFormTest extends DriverBaseTest {

    @Test
    public void formTest() throws InterruptedException {
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html#google_vignette");
        WebElement acceptCookie = driver.findElement(By.id("ez-accept-all"));
        acceptCookie.click();

        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        firstNameInput.sendKeys("Zsolt");

        WebElement lastNameInput = driver.findElement(By.name("lastname"));
        lastNameInput.sendKeys("Szurovecz");

        WebElement maleRadio = driver.findElement(By.id("sex-0"));
        maleRadio.click();

        WebElement sevenYearsExpRadio = driver.findElement(By.id("exp-6"));
        sevenYearsExpRadio.click();

        WebElement datepickerInput = driver.findElement(By.id("datepicker"));
        datepickerInput.sendKeys("2023-01-28");

        WebElement autoTesterCheckbox = driver.findElement(By.cssSelector("input[value='Automation Tester']"));
        autoTesterCheckbox.click();

        WebElement autoToolCheckbox = driver.findElement(By.cssSelector("input[value='Selenium Webdriver']"));
        autoToolCheckbox.click();

        Select continentsDropdown = new Select(driver.findElement(By.cssSelector("select[id='continents']")));
        continentsDropdown.selectByVisibleText("Europe");

        WebElement seleniumCommandsDropdown = driver.findElement(By.id("selenium_commands"));
        seleniumCommandsDropdown.sendKeys(Keys.DOWN);
        seleniumCommandsDropdown.sendKeys(Keys.DOWN);

        WebElement fileUploadInput = driver.findElement(By.id("photo"));
        //WebElement fileUploadInput = driver.findElement(By.cssSelector("input[name='photo'][type='file']"));
        // MACOS esetén:
        fileUploadInput.sendKeys("/Users/zsszurovecz/Desktop/progmaticjrta/ProgmaticTAF/src/test/resources/uploadexample.txt");
        // WINDOWS esetén:
        //fileUploadInput.sendKeys("C:\\Users\\zsszurovecz\\Desktop\\progmaticjrta\\ProgmaticTAF\\src\\test\\resources\\uploadexample.txt");
        Thread.sleep(2000);
    }
}
