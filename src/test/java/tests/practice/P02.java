package tests.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    /*
     . .Exercise2...
1-Driver oluşturalim
2-Java class'imiza chnomedriver.exet i tanitalim
3-Driver'in tum ekranı kaplamasini saglayalim
4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim. Egen oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
5-"https://www.otto.de" adresine gidelim
6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
8-Ardindan "https://wisequarter.com/" adresine gidip,adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
9-Bir onceki web sayfamiza geri donelim
10-Sayfayı yenileyelim
11-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
12- En son adim olarak butun sayfalarimizi kapatmis olalim
     */


    public static void main(String[] args) {

    //1-Java class'imiza chnomedriver.exe'i tanitalim

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");

    //2-Driver oluşturalim

        WebDriver driver=new ChromeDriver();

    //3-Driver'in tum ekranı kaplamasini saglayalim

        driver.manage().window().maximize();

    //4-Driverla sayfanın yuklenmesini 10.000 milisaniye (10 saniye) boyunca beklesini söyleyelim.
    //  Eger oncesinde sayfa Yüklenirse, beklemeyi bıraksın.

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

    //5-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");

    //6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim ve yazdiralim
        System.out.println("Title :"+driver.getTitle());
                      //veya
       // String title= driver.getTitle();
       // System.out.println(title);

        System.out.println("Url :"+driver.getCurrentUrl());
                       //veya
        //String url= driver.getCurrentUrl();
        //System.out.println(url);

    //7-Title ve url inin "OTTO" kelimesinin içerip icermedigini kontrol edelim

       if (driver.getTitle().contains("OTTO")&& driver.getCurrentUrl().contains("OTTO")){
           System.out.println("Test Passed");
       }else {
           System.out.println("Test Failed"); // url otto icerdiginden test failed oldu.
       }

    //8-Ardindan "https://wisequarter.com/" adresine gidip
    // basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim

        driver.navigate().to("https://wisequarter.com");
       if (driver.getTitle().contains("Quarter")){
           System.out.println("wise quarter candir");

       }else{
           System.out.println("wise quarter her daim candir");
       }

    //9-Bir onceki web sayfamiza geri donelim

        driver.navigate().back();

    //10-Sayfayı yenileyelim

        driver.navigate().refresh();

    //11-Daha sonra web sayfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim

        driver.navigate().forward();
        driver.close();

    //12- En son adim olarak butun sayfalarimizi kapatmis olalim

        driver.quit();


    }

}
