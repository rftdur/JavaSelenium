//Before ve After Senaryo Kullanildi.

package elementsExample;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;


public class WebTables {

    static WebDriver cdriver;
    static int milis = 1500;
    static JavascriptExecutor jsx;
    static WebElement elementsButton;
    static WebElement webTablesButton;
    static List<WebElement> rows;
    static String expectedFirstRowColm= "Cierra";
    static String excualFirstRowColm;
    static WebElement searchBox;
    static String searchBoxInputData = "al";
    static String expectedFirstRowColmSearch= "Alden";
    static  WebElement addButton;


    @BeforeClass

    public static void Setup() {

        cdriver = new ChromeDriver();
        jsx = (JavascriptExecutor) cdriver;
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        cdriver.navigate().to("https://demoqa.com/elements");


    }

    @AfterClass
    public static void tearDown () {
        cdriver.quit();
    }
    @Test
    public void test01 () throws InterruptedException {
        elementsButton = cdriver.findElement(By.xpath("//span[text()='Radio Button']"));
        elementsButton.click();
        Thread.sleep(milis);


    }
    @Test
    public void test02 () throws InterruptedException {
        webTablesButton = cdriver.findElement(By.xpath("//span[text()='Web Tables']"));
        webTablesButton.click();
        Thread.sleep(milis);
    }
    @Test
    public void test03 () throws InterruptedException {
        rows = cdriver.findElements(By.xpath("(//div[@class='rt-td'])[1]"));
        excualFirstRowColm = rows.get(0).getText();
        System.out.println("excualFirstRowColm" + excualFirstRowColm);
        Assert.assertEquals(expectedFirstRowColm, excualFirstRowColm);
    }
    @Test
    public void test04 () throws InterruptedException {
        searchBox = cdriver.findElement(By.id("searchBox"));
        searchBox.sendKeys(searchBoxInputData);
        Thread.sleep(milis);
        rows = cdriver.findElements(By.xpath("(//div[@class='rt-td'])[1]"));
        excualFirstRowColm = rows.get(0).getText();
        System.out.println("excualFirstRowColm" + excualFirstRowColm);
        Assert.assertEquals(excualFirstRowColm, expectedFirstRowColmSearch);
    }
    @Test
    public void test05 () throws InterruptedException {
        addButton = cdriver.findElement(By.id("addNewRecordButton"));
        addButton.click();

    }
}
