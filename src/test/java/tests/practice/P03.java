package tests.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    public static void main(String[] args) {

    // 1) Browser açın

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe") ;
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    // 2) “http://practice.automationtesting.in/” adresine gidin
        driver.get("http://practice.automationtesting.in/");

    //3) Sitenin başlığını alıp yazdırın
        System.out.println("Title :"+ driver.getTitle());

     //4) Sitenin url adresini alıp yazdırın
        System.out.println("URL :"+driver.getCurrentUrl());

    //  5) Başlığın Practice ve Url'in  ise practice içerip içermediğini test edin
        if (driver.getTitle().contains("Practice")){
            System.out.println("Başlikta Practice kelimesi vardir/ Test Passed");
        }else{
            System.out.println("Başlikta Practice kelimesi yoktur/ Test Failed");
        }

        if (driver.getCurrentUrl().contains("practice")){
            System.out.println("URL'de practice kelimesi vardir/ Test Passed");
        }else{
            System.out.println("Url'de practice kelimesi yoktur/ Test Failed");
        }

        System.out.println("==========================2.Yontem=====================");
        if (driver.getTitle().contains("Practice") && driver.getCurrentUrl().contains("practice")){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }

    //6) Pencereyi kapatın
        driver.close();





    }



}
