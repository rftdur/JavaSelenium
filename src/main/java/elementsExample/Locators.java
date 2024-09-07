package elementsExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

    public static void main (String [] args) {

        WebDriver cdriver= new ChromeDriver();

        cdriver.navigate().to("https://demoqa.com/text-box");

        cdriver.findElement(By.id("userName")).sendKeys("Rafet");
        cdriver.findElement(By.name("viewport"));
        cdriver.findElement(By.className("mr-sm-2 form-control"));
        cdriver.findElement(By.tagName("label"));
        cdriver.findElement(By.linkText("/images/zero-step.jpeg"));
        cdriver.findElement(By.partialLinkText("katalon"));
        cdriver.findElement(By.xpath("//label"));
        cdriver.findElement(By.xpath("//input[contains(@type,'text')]"));
        cdriver.findElement(By.xpath("//label[contains(text(),'Full Name')]"));
        cdriver.findElement(By.xpath("(//div[@class='element-group'])[6]"));
        cdriver.findElement(By.xpath("//input[@placeholder='Full Name' and @type='text' ]"));
        cdriver.findElement(By.xpath(""));
}
}
