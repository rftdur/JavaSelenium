import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ikinciElementExample {
        static String actualFirstIndexHome;
        static String expectedHomeResult="home";


        public static void main (String[] arg) throws InterruptedException {
            WebDriver cdriver= new ChromeDriver();
            int milis = 1000;
            JavascriptExecutor jsx = (JavascriptExecutor) cdriver;
            cdriver.manage().window().maximize();
            cdriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            cdriver.get("https://demoqa.com");

            WebElement elementButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));
            elementButton.click();
            Thread.sleep(milis);

            WebElement checkBoxButton = cdriver.findElement(By.xpath(" (//li[@class='btn btn-light '])[2]"));
            checkBoxButton.click();
            Thread.sleep(milis);

            WebElement checkBoxHome = cdriver.findElement(By.className("rct-title"));

            boolean isSelectedHome = checkBoxHome.isSelected();

            if (isSelectedHome) {

                System.out.println("Checkbox is already selected");

            } else  {
                checkBoxHome.click();
                System.out.println("CheckBox is selected now");
            }
            Thread.sleep(milis);

            List <WebElement> resultHome = cdriver.findElements(By.className("text-success"));

            for (WebElement result: resultHome ){
                System.out.println(result.getText());
            }
            actualFirstIndexHome =resultHome.get(0).getText();
            Assert.assertEquals(actualFirstIndexHome, expectedHomeResult);

            WebElement toggleButton1 = cdriver.findElement(By.xpath("//button[@title='Toggle']"));

            toggleButton1.click();
            Thread.sleep(milis);

            WebElement checkBoxDeskop = cdriver.findElement(By.xpath("(//span[@class='rct-title'])[1]"));
            WebElement checkBoxDocuments = cdriver.findElement(By.xpath("(//span[@class='rct-title'])[2]"));
            WebElement checkBoxDownloads = cdriver.findElement(By.xpath("(//span[@class='rct-title'])[3]"));

            Assert.assertTrue(checkBoxDeskop.isDisplayed());
            Assert.assertTrue(checkBoxDocuments.isDisplayed());
            Assert.assertTrue(checkBoxDownloads.isDisplayed());

            checkBoxHome.click();
            Thread.sleep(milis);

            if (isSelectedHome) {
                System.out.println("CheckBox is already selected");
            } else {
                System.out.println("checkbox is NOT already selected");

            }
                cdriver.quit();
            }
        }


