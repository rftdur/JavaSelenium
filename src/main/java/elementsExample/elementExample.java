package elementsExample;


import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import static dev.failsafe.internal.util.Assert.state;


public class elementExample {


    static String expectedValidationText= "Please select an item from left to start pratice.";



    static String fullName = "Test";

    static String email = "deneme@test.com";

    static String currentAdress = "Test Mahallesi";

    static String parmenentAdress = "Deneme Test";

    public static void main(String[] args) throws InterruptedException {

        WebDriver cdriver= new ChromeDriver();


        int milis = 2000;

        cdriver.manage().window().maximize();

        cdriver.get("https://demoqa.com/elements"); //URL kurulan browser ile acilir

        Thread.sleep(milis);

       /* WebElement elementsButton = cdriver.findElement(By.xpath("//h5[text()='Elements']"));

        elementsButton.click();
        Thread.sleep(milis);*/

        WebElement textBoxButton = cdriver.findElement(By.xpath("//span[text()='Text Box']"));

        textBoxButton.click();

        Thread.sleep(2000);

        WebElement fullNameLabel= cdriver.findElement(By.cssSelector("#userName"));
        WebElement emailLabel= cdriver.findElement(By.cssSelector("#userEmail"));
        WebElement currentAdressLabel= cdriver.findElement(By.cssSelector("#currentAddress"));
        WebElement parmenantAdressLabel = cdriver.findElement(By.cssSelector("#permanentAddress"));
        WebElement submit = cdriver.findElement(By.cssSelector("#submit"));

        fullNameLabel.sendKeys(fullName);
        Thread.sleep(milis);
        emailLabel.sendKeys(email);
        Thread.sleep(milis);
        currentAdressLabel.sendKeys(currentAdress);
        Thread.sleep(milis);
        parmenantAdressLabel.sendKeys(parmenentAdress);
        Thread.sleep(milis);
        submit.click();
        Thread.sleep(milis);
        Thread.sleep(milis);
        Thread.sleep(milis);

        String actualName = cdriver.findElement(By.cssSelector("#userName")).getText();
        String actualEmail = cdriver.findElement(By.cssSelector("#userEmail")).getText();
        String actualCurrentAdressLabel = cdriver.findElement(By.cssSelector("#currentAddress")).getText();
        String actualparmenantAdressLabel = cdriver.findElement(By.cssSelector("#permanentAddress")).getText();

        System.out.println(actualName);
        System.out.println(actualEmail);
        System.out.println(actualCurrentAdressLabel);
        System.out.println(actualparmenantAdressLabel);












       /* String actualValidationText = cdriver.findElement(By.cssSelector(".col-12.mt-4.col-md-6")).getText();

        state(Boolean.parseBoolean(actualValidationText), expectedValidationText);*/



        cdriver.quit();

    }
}
