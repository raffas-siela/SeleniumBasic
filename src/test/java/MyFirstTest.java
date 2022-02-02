import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTest extends TestBase{

    @Test
    public void shouldLogin(){
        driver.get("https://seleniumui.moderntester.pl/");
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ pageUrl);
        Assert.assertEquals(pageUrl, "https://seleniumui.moderntester.pl/");
    }
}


