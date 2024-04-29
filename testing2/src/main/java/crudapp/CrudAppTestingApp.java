package crudapp;

import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Time;
import java.time.Duration;

public class CrudAppTestingApp {

    public static final String XPATH_INPUT = "//html/body/main/section/form/fieldset/input";
    public static final String XPATH_TEXTAREA = "//html/body/main/section/form/fieldset[2]/textarea";
    public static final String XPATH_WAIT_FOR = "//select[1]";
    public static final String XPATH_SELECT = "//div[contains(@class, \"tasks-container\")]/form/div/fieldset/select[1]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://ayuru.github.io");

        WebElement searchfield = driver.findElement(By.xpath(XPATH_INPUT));
        searchfield.sendKeys("Kamehameha");

        WebElement textareaField = driver.findElement(By.xpath(XPATH_TEXTAREA));
        textareaField.sendKeys("Hit him!");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed()) {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement selectCombo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECT)));
            Select selectBoard = new Select(selectCombo);
            selectBoard.selectByIndex(1);
        }

    }

}