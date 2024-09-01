package Selenium.project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class denemeProject
{
    public static void main(String[]arg) {

        WebDriver cdriver= new ChromeDriver();

        cdriver.get("https://demoqa.com");
        System.out.println("Mevcut Pencere URL:" +cdriver.getCurrentUrl());
        System.out.println("Hash Kodu:" +cdriver.getWindowHandle());
        System.out.println("Sayfa Başlığı:" +cdriver.getTitle());
        System.out.println("--------------------Page Source-----------------------");
        System.out.println(cdriver.getPageSource());
}
}
