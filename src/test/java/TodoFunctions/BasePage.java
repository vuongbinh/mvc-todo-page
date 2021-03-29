package TodoFunctions;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    WebDriver driver;
    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract void open();

    public String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
