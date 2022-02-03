/*
3. Iframes
        Test steps:
        1. Switch to the first iframe and fill form
        2. Switch to the second iframe and fill form
        3. Switch to the main frame and click on 'Basic' button in the main menu
*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class IframeTest extends TestBase{
    @Test
    public void fillIframe1(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        driver.switchTo().frame("iframe1");
        driver.findElement(By.id("inputFirstName3")).sendKeys("Tom");
        driver.findElement(By.id("inputSurname3")).sendKeys("Cat");
        driver.findElement(By.cssSelector("div>button")).click();
        driver.switchTo().defaultContent();
    }
    @Test
    public void fillIframe2(){
        driver.get("https://seleniumui.moderntester.pl/iframes.php");
        driver.switchTo().frame("iframe2");
        driver.findElement(By.id("inputLogin")).sendKeys("tom");
        driver.findElement(By.id("inputPassword")).sendKeys("tom1234");

        Select continents = new Select(driver.findElement(By.id("inlineFormCustomSelectPref")));
        continents.selectByVisibleText("Europe");

        List<WebElement> professions = driver.findElements(By.name("gridRadios"));
        getRandomElementYear(professions).click();
        System.out.println(professions);

    }
    private WebElement getRandomElementYear(List<WebElement> elements) {
        Random random = new Random();
        return elements.get(random.nextInt(elements.size()));
    }
}
