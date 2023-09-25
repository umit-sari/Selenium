package tests.day04_xPath_ccsSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Xpath_TextKullanimi {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        // 3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu = driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButonu.isDisplayed()) {
            System.out.println("Delete butonu testi passed");
        } else {
            System.out.println("Delete butonu testi failed");
        }

        // 4- Delete tusuna basin
        deleteButonu.click();

        // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYazisi=driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYazisi.isDisplayed()) {
            System.out.println("addRemoveYazisi butonu testi passed");
        } else {
            System.out.println("addRemoveYazisi butonu testi failed");
        }
        driver.close();
    }
}
