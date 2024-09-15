package elementsExample;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import scala.reflect.internal.Trees;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Links {

    //HTTP
    static HttpURLConnection connection;
    static int responseCode;


    static WebDriver cdriver;
    static WebElement elementsButton;
    static WebElement homeLinks;
    static Set<String> windows;
    static Iterator<String> window;
    static String parenId;
    static String childIdOne;
    static WebElement elementsButtonWait;
    static ExpectedCondition elementsButtonIsDisplayed;

    //Links
    static List<WebElement> links;
    static String url;
    static String urlText;

    int milis =100;

    @BeforeClass
    public static void Setup (){

        cdriver = new ChromeDriver();
        cdriver.manage().window().maximize();
        cdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        cdriver.get("https://demoqa.com/elements");

    }

    @AfterClass
    public static void tearDown (){
        cdriver.quit();

    }

    @Test
    public void test01 () throws InterruptedException {

        elementsButton = cdriver.findElement(By.xpath("//span[text()='Links']"));
        elementsButton.click();
        Thread.sleep(milis);

    }

    @Test
    public void test02 () throws InterruptedException {
        homeLinks = cdriver.findElement(By.linkText("Home"));
        homeLinks.click();
        Thread.sleep(milis);
    }

    @Test
    public void test03 () {

        windows = cdriver.getWindowHandles();
        window = windows.iterator();
        parenId= window.next();
        childIdOne= window.next();
        cdriver.switchTo().window(childIdOne);
        elementsButtonWait = new WebDriverWait(cdriver, Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='card-body'])[1]")));
        elementsButtonIsDisplayed= ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='card-body'])[1]"));
        System.out.println(elementsButtonIsDisplayed);
        cdriver.close();
        cdriver.switchTo().window(parenId);
    }
    @Test
    public void test04 () {

        links = cdriver.findElements(By.tagName("a"));
        for (int i =0; i< links.size(); i++ ){
            url = links.get(i).getAttribute("href");
            urlText = links.get(i).getText();
            try {

                connection = (HttpURLConnection) new URL(url).openConnection();
                connection.setRequestMethod("HEAD");
                connection.connect();

                responseCode = connection.getResponseCode();
                System.out.println("URL:" + url +" | " + "Returned_Response_Code:" + responseCode + " | " + "URL Text" + urlText);

            } catch (IOException e){
                System.out.println("Error Checking Response for URL" + url + " | " + "URL Text: " + urlText);
            }
        }

    }
}


