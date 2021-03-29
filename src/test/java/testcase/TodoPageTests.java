package testcase;

import TodoFunctions.TodoFunctions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TodoPageTests extends BaseTest {

    @DataProvider
    Object[][] ListTask() {
        return new Object[][]{
                new Object[]{"01. Do HomeWork"},
                new Object[]{"02. Lunch"},
                new Object[]{"03. Play"},
                new Object[]{"04. Watch TV"},
                new Object[]{"05. Play football"},
                new Object[]{"06. Walking on the Moon"},
                new Object[]{"07. Go to the school"},
                new Object[]{"08. Commit code to Github"},
                new Object[]{"09. Sleeping"},
                new Object[]{"10. Go to the store"},
                new Object[]{"11. Shoot the plate"},
        };
    }

    @Test(dataProvider = "ListTask")
    void addNewTask(String task_name) {
        TodoFunctions functions = new TodoFunctions(driver);
        functions.open();
        functions.add(task_name);
        Assert.assertTrue(functions.getResult(task_name));
    }
}
