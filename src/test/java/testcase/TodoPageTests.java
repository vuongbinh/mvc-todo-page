package testcase;

import TodoFunctions.TodoFunctions;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TodoPageTests extends BaseTest {

    @DataProvider
    Object[][] ListTask() {
        return new Object[][]{
                new Object[]{"Do HomeWork"},
                new Object[]{"@$!@8#"},
                new Object[]{"98830031"},
                new Object[]{"7820038831"},
                new Object[]{"90119928231892883991882992821100000111"},
                new Object[]{"^&&@@(!(&@"},
                new Object[]{"11. Shoot the plate"},
        };
    }

    @Test(dataProvider = "ListTask")
    void addNewTask(String task_name) {
        TodoFunctions todo = new TodoFunctions(driver);
        todo.open();
        int itemsBefore = todo.countItems();
        todo.add(task_name);
        int itemsAfter = todo.countItems();
        Assert.assertTrue(todo.isExist(task_name));
        Assert.assertEquals(itemsAfter-itemsBefore,1);
    }

    @DataProvider
    Object[][] ListEditTask() {
        return new Object[][]{
                new Object[]{"01. Do HomeWork", "01. Do HomeWork - edited"},
        };
    }

    @Test(dataProvider = "ListTask")
    void remove(String task_name) {
        TodoFunctions todo = new TodoFunctions(driver);
        todo.open();
        int before = todo.countItems();
        todo.remove(task_name);
        int after = todo.countItems();

        Assert.assertEquals(after-before,-1);

    }
}
