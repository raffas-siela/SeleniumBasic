/*
4. Tables
        Test steps:
        1. Get all rows from table to List
        2. Print out 'Rank', 'Peak' and 'Mountain range' of mountains that are in "Switzerland" and are higher than 4000 m
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TablesTest extends TestBase{
    @Test
    public void table(){
        driver.get("https://seleniumui.moderntester.pl/table.php");
        List<WebElement> mountains = driver.findElements(By.cssSelector("tbody tr"));

        for (WebElement mountain : mountains){
            System.out.println(mountain.findElement(By.cssSelector("th")).getText());
            int height = Integer.parseInt(mountain.findElements(By.cssSelector("td")).get(2).getText());
            Assert.assertTrue(height>0);


        }

    }
}
