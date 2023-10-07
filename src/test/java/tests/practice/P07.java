package tests.practice;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.time.Duration;

public class P07 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        WebElement signinButonu = driver.findElement(By.xpath("//button[@id='signin_button']"));
        signinButonu.click();

        // 3. Login alanine  “username” yazdirin

        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");

        //4. Password alanina “password” yazdirin
        driver.findElement(By.xpath("//*[@name='user_password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin

        driver.findElement(By.xpath("//input[@type='submit']")).click();


        //6. Back tusu ile sayfaya donun

        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazi
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("10000");

        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        //10. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement mesajYazisi= driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if (mesajYazisi.isDisplayed()){

            System.out.println("The Payment yazisi PASSED");
        }else{
            System.out.println("The Payment yazisi FAIlED");
        }

        driver.close();

    }
}
