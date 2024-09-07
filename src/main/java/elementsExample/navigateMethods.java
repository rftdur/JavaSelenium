package elementsExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigateMethods {

    public static void main(String[] args) throws InterruptedException {

        int milis = 2000;

        WebDriver cdrive= new ChromeDriver();

        cdrive.get("https://demoqa.com");
        System.out.println("Ana Sayfa Acildi");
        Thread.sleep(milis);

        cdrive.navigate().to("https://demoqa.com/elements");
        System.out.println("Element Sayfasi Acildi");


        cdrive.navigate().back();
        System.out.println("Eski Sayfaya Dönüldü");
        Thread.sleep(milis);

        cdrive.navigate().refresh();
        System.out.println("Sayfa Refresh Edildi");
        Thread.sleep(milis);

        cdrive.navigate().forward();
        System.out.println("İleri Sayfaya Gidildi");
        Thread.sleep(milis);

        cdrive.close();
        cdrive.quit();

    }
}
