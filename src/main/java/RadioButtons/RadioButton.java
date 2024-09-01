package RadioButtons;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioButton {

    static String expectedRadioPageMessage = "Do you like the site?";

    static  String expectedYesMessage ="Yes";

    static  String expectedImpressiveMassege= "Impressive";

    public static void main (String[] args) throws InterruptedException {

        WebDriver cdriver = new ChromeDriver();

        int milis = 2000;

        JavascriptExecutor jsx = (JavascriptExecutor) cdriver;

        cdriver.manage().window().maximize();

        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        cdriver.get("https://demoqa.com/elements");

       /* WebElement elementButton = cdriver.findElement(By.xpath("//h5[text()='elements']"));

        elementButton.click();
        Thread.sleep(milis);*/

        WebElement radioButton = cdriver.findElement(By.xpath("//span[text()='Radio Button']"));


        radioButton.click();
        Thread.sleep(milis);


        String actualRadioButtonMassege = cdriver.findElement(By.cssSelector(".mb-3")).getText();

        Assert.assertEquals(actualRadioButtonMassege, expectedRadioPageMessage);

        WebElement radioButtonYes = cdriver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]"));

        radioButtonYes.click();
        Thread.sleep(milis);

        String yesButtonCheck = cdriver.findElement(By.xpath("//span[@class='text-success']")).getText();

        Assert.assertEquals(yesButtonCheck, expectedYesMessage);

        WebElement impressiveButton = cdriver.findElement(By.xpath("//label[@for='impressiveRadio']"));

        impressiveButton.click();
        Thread.sleep(milis);

        String impressiveButtonCheck = cdriver.findElement(By.xpath("//span[@class='text-success']")).getText();

        Assert.assertEquals(impressiveButtonCheck, expectedImpressiveMassege );

        WebElement radioNoButton = cdriver.findElement(By.xpath("//label[@for='noRadio']"));

        boolean isClicktableNoButton = radioNoButton.isEnabled();

        System.out.println("State :" + isClicktableNoButton);

        if (isClicktableNoButton) {
            System.out.println("No botton is not clicktable");
        }
        Thread.sleep(milis);

        cdriver.quit();
    }

}
