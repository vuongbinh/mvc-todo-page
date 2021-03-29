package TodoFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TodoFunctions extends BasePage {

    By input = By.className("new-todo");
    String locatorResult = "//label[.='%s']";

    public TodoFunctions(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://todomvc.com/examples/vanillajs/");
    }

    public boolean getResult(String task_name) {
        return driver.findElement(By.xpath(locatorResult.formatted(task_name))).getText().contains(task_name);
    }

    public void add(String task_name) {
        driver.findElement(input).sendKeys(task_name);
        driver.findElement(input).sendKeys(Keys.ENTER);
    }


}
