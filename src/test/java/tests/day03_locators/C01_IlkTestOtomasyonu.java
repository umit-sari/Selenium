package tests.day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_IlkTestOtomasyonu {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com.tr");

        // arama kutusuna "Nutella" yazdirip aratin
        // once arama kutusunu findElement() ve Locator ile driver'a tanitip
        // o web elementi bu class'ta kullanabilecegimiz sekilde kaydediyoruz.

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox")); // arama kutusunu bulma-
        // boyle bir element bulamaz ise "NoSuchElementException" hatasi verir.

        /*
        aramaKutusu.sendKeys("Nutella");
        aramaKutusu.submit();
        Bunu tek satirda yapmak istersek asagidaki gibi yazabiliriz.
         */

        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);


        // arama sonuclarinin "Nutella" icerdigini test edin

        // WebElement aramaSonucuElemeti= driver.findElement(By.className("a-section a-spacing-small a-spacing-top-small"));
        // By.className locator'i class attribute'unun degeri bosluk icerdiginde saglikli CALISMADI.
        //WebElement aramaSonucuElemeti= driver.findElement(By.className("sg-col-inner"));
        //System.out.println(aramaSonucuElemeti.getText());


        /*
         By.className locator'i class attribute'unun degeri bosluk icerdiginde
         saglikli CALISMAZ
         Cogunlukla class ismi ayni ozelliklerdeki webelementleri gruplandirmak icin kullanilir
         Biz de class degeri sg-col-inner arattigimizda 73 tane webelement buldu

         */

        // WebElement aramaSonucElementi= driver.findElement(By.className("sg-col-inner"));

        List<WebElement> elementlerListesi = driver.findElements(By.className("sg-col-inner"));
        String actualAramaSonucu = elementlerListesi.get(0).getText();
        String expectedIcerik = "Nutella";

        if (actualAramaSonucu.contains("Nutella")){
            System.out.println("Ilk otomasyon testi PASSED");
        }else{
            System.out.println("Ilk otomasyon testi FAILED");
        }

        driver.close();

    }
}
