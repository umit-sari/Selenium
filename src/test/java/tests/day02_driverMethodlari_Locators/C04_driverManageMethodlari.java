package tests.day02_driverMethodlari_Locators;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_driverManageMethodlari {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // gorev odakli calisir, 15 saniye maximum bekleme suresidir
        // gorev daha once tamamlanirsa, yoluna devam eder
        // 15 saiye icinde gorev tamamlanmazsa hata verir
        // gorev : sayfanin acilmasi ve kullanilacak webelementlerin bulunmasidir

        System.out.println("maximize size :"+ driver.manage().window().getSize()); // (1382, 736) pixel
        System.out.println("maximize konum : " + driver.manage().window().getPosition()); // (-8, -8)

        // window'u fullscreen yapin
        driver.manage().window().fullscreen();

        System.out.println("fullscreen size :"+ driver.manage().window().getSize()); // (1366, 768)
        System.out.println("fullscreen konum : " + driver.manage().window().getPosition()); // (0,0)

        // window'un baslangic konumunu (200,300) ve boyutunu (500,500) yapin

        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(200,300));

        System.out.println("customize size :"+ driver.manage().window().getSize()); // (516, 500)
        System.out.println("customize konum : " + driver.manage().window().getPosition()); // (200, 300)

        Thread.sleep(3000); // java'dan gelir ve kodlari bekletir
        driver.close();
    }
}