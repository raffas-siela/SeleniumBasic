/*1.2 Prompt Alert box
Test steps:
1. Click on 'Prompt Pop up' button
2. Type "Lord Vader" in the alert text box
3. Click 'OK' button on alert
4. Check that "Hello Lord Vader! How are you today?" text has been shown*/

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

import static org.bouncycastle.crypto.tls.ContentType.alert;

public class PromptAlertBoxTest extends TestBase{

    @Test
    public void buttonPress() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("prompt-alert")).click();
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        String name = "Lord Vader";
        promptAlert.sendKeys(name);
        promptAlert.accept();
        Assert.assertEquals("Hello " + name + "! How are you today?", "Hello Lord Vader! How are you today?");
    }
}
