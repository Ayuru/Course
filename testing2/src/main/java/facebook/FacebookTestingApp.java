package facebook;


import config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES = "//div[contains(@class, \"_4-i2\")]/div[4]/button";
    public static final String XPATH_REGISTER = "//div[contains(@class, \"_8iep\")]/div/form/div[5]/a";

    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        boolean cookiesAccepted = false;
        while (!cookiesAccepted) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_COOKIES))).click();
                cookiesAccepted = true;
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        }

        driver.findElement(By.xpath(XPATH_REGISTER)).click();

        WebElement day = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECT_DAY)));
        Select selectDay = new Select(day);
        selectDay.selectByValue("19");

        WebElement month = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECT_MONTH)));
        Select selectMonth = new Select(month);
        selectMonth.selectByValue("2");

        WebElement year = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_SELECT_YEAR)));
        Select selectYear = new Select(year);
        selectYear.selectByValue("1925");

    }

}