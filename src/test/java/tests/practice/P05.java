package tests.practice;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    public static void main(String[] args) throws InterruptedException {
        // 1-Driver oluşturalim -2-Java class'imiza chnomedriver. exetyi tanitalim
        System.setProperty("webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // 3-Driver'in tum ekranı kaplamasini sagu ayalim
        driver.manage().window().maximize();
        //4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
        //Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10809));

        // 5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.get("http://www.babayigit.net/murat/testpage.html");


        //6-first name, surname, age, Your Job, Birth Palace,
        // Last graduated school, Number of Children alanlarına gerekli bilgileri yazsın
         driver.findElement(By.id("ad")).sendKeys("Umit");
         driver.findElement(By.id("soyad")).sendKeys("sari");
         driver.findElement(By.id("yas")).sendKeys("38");
         driver.findElement(By.id("meslek")).sendKeys("Tester");
         driver.findElement(By.id("dogum_yeri")).sendKeys("Tunceli");
         driver.findElement(By.id("mezun_okul")).sendKeys("Istanbul Universitesi");
         driver.findElement(By.id("cocuk_sayisi")).sendKeys("3");

        //7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        //8- "All information was entered correctly.." yazısının göründüğünü test etsin ve sonucu yazdirin
        String expectedResult="All information was entered correctly..";
        String actualResult=driver.findElement(By.id("uyari")).getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("Uyari yazisi gorunurluk testi: Passed");
        }else{
            System.out.println("Uyari yazisi gorunurluk testi: Failed");
        }

        //9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@value='Clear']")).click();

        // 10- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(2000);
        //11- Sayfayı kapatsın
        driver.close();

    }
}
