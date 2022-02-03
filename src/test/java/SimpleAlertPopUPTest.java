/*1.1 Simple Alert Pop up
Test steps:
1. Click on 'Simple Alert' button
2. Click 'OK' button on alert
3. Check that "OK button pressed" text has been shown*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleAlertPopUPTest extends TestBase{
    @Test
    public void buttonPress(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("simple-alert")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String message = driver.findElement(By.id("simple-alert-label")).getText();
        Assert.assertEquals(message, "OK button pressed");
    }
}
