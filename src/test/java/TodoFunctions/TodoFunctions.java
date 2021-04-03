package TodoFunctions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TodoFunctions extends BasePage {

    By todoTxt = By.className("new-todo");
    By todoList = By.cssSelector(".todo-list li");
    String locatorResult = "//label[.='%s']";


    public TodoFunctions(WebDriver driver) {
        super(driver);
    }

    public By getLocator(String task_name){
        return By.xpath("//label[.='%s']/following-sibling::button".formatted(task_name));
    }

    @Override
    public void open() {
        driver.get("https://todomvc.com/examples/vanillajs/");
    }

    public boolean isExist(String task_name) {
        return driver.findElement(By.xpath(locatorResult.formatted(task_name))).getText().contains(task_name);
    }

    public void add(String task_name) {
        driver.findElement(todoTxt).sendKeys(task_name,Keys.ENTER);
    }

    public void edit(String task_name, String new_name) {
        Actions actions = new Actions(driver);
        actions.doubleClick
                (driver.findElement(By.xpath(locatorResult.formatted(task_name))))
                .perform();
        driver.findElement(By.cssSelector(".edit")).
                sendKeys(Keys.chord(Keys.COMMAND,"a"),
                        Keys.BACK_SPACE,
                        new_name,
                        Keys.ENTER);
    }

    public void remove(String task_name){
        Actions mouse = new Actions(driver);
        WebElement ava = driver.findElement(By.xpath(locatorResult.formatted(task_name)));
        mouse
                .moveToElement(ava)
                .perform();
        driver.findElement(getLocator(task_name)).click();
    }

    public int countItems(){
        return driver.findElements(todoList).size();
    }


}
