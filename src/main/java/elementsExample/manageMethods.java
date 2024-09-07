package elementsExample;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class manageMethods {

    int milis=2000;

    static String fullName = "Test";

    static String email = "deneme@test.com";

    static String currentAdress = "Test Mahallesi";

    static String parmenentAdress = "Deneme Test";


    public void main(String[] args) throws InterruptedException {
        WebDriver cdriver= new ChromeDriver();
        cdriver.get("https://demoqa.com");
        System.out.println("Mevcut Büyüklük: " + cdriver.manage().window().getSize());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cdriver.manage().window().setSize(new Dimension(800,600));

        Thread.sleep(2000);

        System.out.println("Mevcut Büyüklük:" + cdriver.manage().window().getSize());


        Thread.sleep(2000);

        WebElement elementButton = cdriver.findElement(By.xpath("//h5[contains(text(),'Element')]"));

        elementButton.click();

        Thread.sleep(2000);


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


        textBoxButton.click();

        Thread.sleep(2000);


        cdriver.manage().window().setPosition(new Point(200,15));


        Thread.sleep(2000);

        System.out.println("Mevcut Büyüklük" + cdriver.manage().window().getSize());
        System.out.println("Yeni Büyüklük" + cdriver.manage().window().getPosition());

        cdriver.manage().window().fullscreen();
        System.out.println("FullScreen Büyüklük" + cdriver.manage().window().getSize());

        Thread.sleep(2000);

        cdriver.manage().window().maximize();
        System.out.println("Maximize Büyüklük" + cdriver.manage().window().getSize());

        Thread.sleep(2000);

        cdriver.manage().window().minimize();
        System.out.println("Minimize Büyüklük" + cdriver.manage().window().getSize());
        System.out.println("Minimize Büyüklük" + cdriver.manage().window().getPosition());

        cdriver.navigate().refresh();

        cdriver.quit();




    }
}
