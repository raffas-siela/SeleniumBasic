import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleAlertPopUPTest extends TestBase{
    @Test
    public void buttonPressed (){
        driver.get("https://seleniumui.moderntester.pl/alerts.php");
        driver.findElement(By.id("simple-alert")).click();
        //String message = driver.findElement(By.ByLinkText("OK")).getText();
        //Assert.assertEquals(message, "OK button pressed");


    }
}
