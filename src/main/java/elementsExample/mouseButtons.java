package elementsExample;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class mouseButtons {
    static WebDriver cdriver;
    static Actions actions;

    //Elements button
    static WebElement elementsButton;

    static WebElement buttonButtons;

    static WebElement doubleClickButton;

    static WebElement rightClick;

    static WebElement ClickMe;

    //String

    static String actualDoubleClickMessage;
    static String expectedDoubleClickMessage = "You have done a double click";

    static String actualRightClickMessage;
    static String expectedRigtClickMessage = "You have done a right click";

    static String actualClickMessage;
    static String expectedClickMessage= "You have done a dynamic click";


    @BeforeClass
    public static void setUp () {
        cdriver = new ChromeDriver();
        actions = new Actions (cdriver);
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cdriver.get("https://demoqa.com/elements");

    }
    @AfterClass

    public static void tearDown () {
        cdriver.quit();


    }
    @Test

    public void test02(){

        buttonButtons = cdriver.findElement(By.xpath("//span[text()='Buttons']"));
        buttonButtons.click();

    }
    @Test

    public void test03(){

        doubleClickButton = cdriver.findElement(By.id("doubleClickBtn"));
        actions.moveToElement(doubleClickButton).doubleClick().perform();
        actualDoubleClickMessage = cdriver.findElement(By.id("doubleClickMessage")).getText();
        System.out.println("Double Click Message: " + actualDoubleClickMessage);
        Assert.assertEquals(actualDoubleClickMessage, expectedDoubleClickMessage);

    }
    @Test
    public void test04 () {

        rightClick = cdriver.findElement(By.id("rightClickBtn"));
        actions.moveToElement(rightClick).contextClick().perform();
        actualRightClickMessage = cdriver.findElement(By.id("rightClickMessage")).getText();
        System.out.println("Right Click Message: " + actualRightClickMessage);
        Assert.assertEquals(actualRightClickMessage, expectedRigtClickMessage);



    }
    @Test
    public void test05(){

        ClickMe = cdriver.findElement(By.xpath("//button[text()='Click Me']"));
        actions.moveToElement(ClickMe).doubleClick().perform();
        actualClickMessage = cdriver.findElement(By.id("dynamicClickMessage")).getText();
        System.out.println("ClickMe Message: " + actualClickMessage);
        Assert.assertEquals(actualClickMessage,expectedClickMessage);

    }
}
