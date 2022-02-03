/*1.3 Confirm Alert box
        Test steps:
        1. Click on 'Confirm Pop up' button
        2. Click 'OK' button on alert
        3. Check that "You pressed OK!" has been shown
        4. Click again on 'Confirm Pop up' button
        5. Click 'Anuluj'/'Cancel' button on alert
        6. Check that "You pressed Cancel!" text has been shown

 */

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ConfirmAlertBoxTest extends TestBase{
    @Test
    public void pressButtonOk() {
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        WebElement buttonConfirmPopUP = driver.findElement(By.id("confirm-alert"));
        buttonConfirmPopUP.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        String message = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(message, "You pressed OK!");
        System.out.println(message);
    }
    @Test
    public void pressButtonCancel(){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        WebElement buttonConfirmPopUP = driver.findElement(By.id("confirm-alert"));
        buttonConfirmPopUP.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        String message = driver.findElement(By.id("confirm-label")).getText();
        Assert.assertEquals(message, "You pressed Cancel!");
        System.out.println(message);
    }
}
