package tests.day02_driverMethodlari_Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_driverNavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        Thread.sleep(2000); // biz görmek icin bekletiyoruz ama testlerde gordukten sonra beklemeleri silmeliyiz.
        // cunku test sayisi * bekleme suresi kadar artı zamanimizi alir.


        // ana sayfanin "smile more" icerdigini kontrol edin
        String expectedTitleIcerik = "smile more";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleIcerik)) {
            System.out.println("amazon title testi:PASSED");
        } else {
            System.out.println("amazon title testi:FAILED");
        }

        // youtube ana sayfaya gidin
        driver.navigate().to("https://www.youtube.com");
        Thread.sleep(2000);


        // url'in "youtube" icerdigini test edin

        String expectedUrlIcerik = "youtube";
        String actualUrlIcerik = driver.getCurrentUrl();

        if (actualUrlIcerik.contains(expectedUrlIcerik)) {

            System.out.println("youtube url testi:PASSED");
        } else {
            System.out.println("youtube url testi:FAILED");
        }


        // tekrar amazon anasayfaya donun
        driver.navigate().back();
        Thread.sleep(2000);

        // ve url'in "ramazon" icermedigini test edin
        String unexpectedUrlIcerik = "ramazon";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(unexpectedUrlIcerik)) {
            System.out.println("amazon Url testi:FAILED");
        } else {
            System.out.println("amazon Url testi:PASSED"); // istemedigimiz bir durum
        }


        // tekrar youtube ansayfaya gidin
        driver.navigate().forward();
        Thread.sleep(2000);
        // sayfa kaynak kodlarinda "music" gectigini test edin

        String expectedSayfaIcerik = "music";
        String actualSayfaKaynakKodlari = driver.getPageSource();

        if (actualSayfaKaynakKodlari.contains(expectedSayfaIcerik)) {

            System.out.println("youtube kaynak kodu testi:PASSED");
        } else {
            System.out.println("youtube kaynak kodu testi:FAILED");
        }

        // sayfayi kapatin
        driver.close();

    }
}

