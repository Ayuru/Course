package crudapp;

import config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://ayuru.github.io";
    private WebDriver driver;
    private Random generator = new Random();

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get(BASE_URL);
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudeAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"https\")]/fieldset/input[1]";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"https\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"https\")]/fieldset[3]/button";
        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();

        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);

    }

    private boolean checkTaskExistInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driverTrello.get(TRELLO_URL);

        Thread.sleep(4000);

        driverTrello.findElement(By.id("username")).sendKeys("ayuru.gi@gmail.com");
        WebElement el = driverTrello.findElement(By.id("login-submit"));
        el.submit();

        Thread.sleep(4000);

        driverTrello.findElement(By.id("password")).sendKeys("Pikachu666");
        el.submit();

        Thread.sleep(4000);

        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> !aHref.findElements(By.xpath(".//div[@title=\"Try it\"]")).isEmpty())
                .forEach(WebElement::click);

        Thread.sleep(10000);

        result = driverTrello.findElements(By.xpath("//a")).stream()
                .anyMatch(theA -> theA.getText().equals(taskName));

        Thread.sleep(4000);

        driverTrello.close();

        return result;
    }

    public boolean deleteTestTaskFromCrud(String taskName) throws InterruptedException {

        boolean deleted = false;

        driver.navigate().refresh();

        Thread.sleep(8000);

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(form -> {
                    WebElement button = form.findElement(By.xpath(".//button[@data-task-delete-button]"));
                    button.click();
                });

        Thread.sleep(8000);

        deleted = driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .noneMatch(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName));

        Thread.sleep(8000);

        return deleted;

    }


    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudeAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistInTrello(taskName));
        assertTrue(deleteTestTaskFromCrud(taskName));
    }

}
