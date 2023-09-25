package tests.day04_xPath_ccsSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
       // 2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[@*='addElement()']")).click();

      //  3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteButonu=driver.findElement(By.xpath("//button[@*='deleteElement()']"));
        if (deleteButonu.isDisplayed()){
            System.out.println("Delete Butonu Passed");
        }else{
            System.out.println("Delete Butonu Failed");
        }
       // 4- Delete tusuna basin
        deleteButonu.click();

       // 5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        //WebElement addRemoveYazisi=driver.findElement(By.tagName("h3"));
        WebElement addRemoveYazisi=driver.findElement(By.xpath("//h3")); // xpath ile kullanacak isek // kullanmaliyiz
        if (addRemoveYazisi.isDisplayed()){
            System.out.println("addRemove butonu testi passed");
        }else{
            System.out.println("addRemove butonu testi passed");
        }
        Thread.sleep(10);
        driver.close();


    }
}
