/*zadanie 3:
        Stoworzyć projekt o nazwie SeleniumBasic
        Dodać TestBase -> jak na prezentacji
        uzupełnić pom -> jak na prezentacji
        zrobić test który wchodzi na https://seleniumui.moderntester.pl/
        a następna sprawdza asercją czy URL otwarty w przeglądarce jest równy "https://seleniumui.moderntester.pl/"

 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class URLTest extends TestBase{

    @Test
    public void shouldLogin(){
        driver.get("https://seleniumui.moderntester.pl/");
        String pageUrl = driver.getCurrentUrl();
        System.out.println("Current Url is:"+ pageUrl);
        Assert.assertEquals(pageUrl, "https://seleniumui.moderntester.pl/");
    }
}


