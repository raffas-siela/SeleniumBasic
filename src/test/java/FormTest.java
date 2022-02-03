/*Zadanie 5
        Test steps:

        Fill First name
        Fill Last name
        Fill Email
        Choose a random 'Sex' radiobutton
        Fill age
        Choose a random 'Year of experience' radiobutton
        Choose 'Automation Tester' profession
        Select random option from 'Continents'
        Select "Switch Commands" and "Wait Commands" from 'Selenium Commands'
        Upload some File
        Click 'Sign in' button
        Check that "Form send with success" text has been shown
        Gratis to tego zadania:
        Poszukajcie jak ustawić domyślny folder pobierania w chromedriverze
        Ustawcie wybrany przez was folder
        'Policzcie' przy pomocy javy jaka jest ilość plików w tym folderze
        kliknijcie w formularzu przycisk 'Test File to Download'
        Sprawdźcie czy ilość plików w folderze jest taka jak wcześniej +1
        Dla chętnych: możecie spróbować pobrać listę plików w danym folderze i sprawdzić czy zawiera ona ten plik test-file-to-download.xlsx*/

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;
import java.util.Random;

public class FormTest extends TestBase {

    @Test
    public void shouldLoginWithSuccess() {

        driver.get("https://seleniumui.moderntester.pl/form.php");

        WebElement firstName = driver.findElement(By.cssSelector("#inputFirstName3"));
        firstName.sendKeys("Jan");

        WebElement lastName = driver.findElement(By.id("inputLastName3"));
        lastName.sendKeys("Kowalski");

        driver.findElement(By.id("inputEmail3")).sendKeys("jan.kowalski@gmail.com");

        List<WebElement> sex = driver.findElements(By.name("gridRadiosSex"));
        sex.get(1).click();

        driver.findElement(By.id("inputAge3")).sendKeys("24");

        driver.findElement(By.id("gridCheckManulTester")).click();
        driver.findElement(By.id("gridCheckAutomationTester")).click();
        driver.findElement(By.id("gridCheckOther")).click();

        List<WebElement> professions = driver.findElements(By.name("gridRadiosExperience"));
        //professions.get(3).click();
        getRandomElementYear(professions).click();

        Select continents = new Select(driver.findElement(By.id("selectContinents")));
        continents.selectByVisibleText("Europe");
        //List<WebElement> continents = driver.findElements(By.id("selectContinents"));
        //getRandomElementContinent(continents).click();

        Select seleniumComands = new Select(driver.findElement(By.id("selectSeleniumCommands")));
        seleniumComands.selectByVisibleText("Browser Commands");
        seleniumComands.selectByValue("switch-commands");
        seleniumComands.selectByIndex(4);

        File file = new File("src/main/resources/file1.txt");
        driver.findElement(By.id("chooseFile")).sendKeys(file.getAbsolutePath());

        driver.findElement(By.cssSelector(".btn-primary")).click();
        String message = driver.findElement(By.cssSelector("#validator-message")).getText();
        Assert.assertEquals(message, "Form send with success");
        System.out.println(message);
    }
    //zwraca losowy element z listy
    private WebElement getRandomElementYear(List<WebElement> elements) {
        Random random1 = new Random();
        return elements.get(random1.nextInt(elements.size()));
    }
    /*private int getRandomElementContinent(List<WebElement> continents) {
        int randomContinent = (int)Math.random(continents.size());       
        return randomContinent;
    }*/
}