package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.qatarairways.com/");
        driver.findElement(By.xpath("//a[@class='nav-link mobile_Book']")).click();
        driver.findElement(By.id("Flight schedule")).click();
        driver.findElement(By.id("mat-form-field-infix ng-tns-c44-1")).sendKeys("Doha");
        driver.findElement(By.id("mat-form-field-infix ng-tns-c44-2")).sendKeys("Istanbul"+ Keys.ENTER);
        driver.findElement(By.id("mat-autocomplete ng-tns-c44-2")).sendKeys("28/09/2023");

    }
}
