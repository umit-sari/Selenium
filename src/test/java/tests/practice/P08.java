package tests.practice;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P08 {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "kurulumDosyalari/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get(" http://babayigit.net/relativelocators/relative.html");

    //2 ) Nurse  3 farkli relative locator ile locate edin

        WebElement doctor= driver.findElement(By.xpath("//*[@src='doctor.png']"));

        WebElement nurse1=driver.findElement(RelativeLocator.with(By.tagName("img")).below(doctor));

        WebElement fireman= driver.findElement(By.xpath("//img[@src='fireman.png']"));

        WebElement nurse2=driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(fireman));

        WebElement seller= driver.findElement(By.xpath("//img[@src='seller.png']"));

        WebElement nurse3=driver.findElement(RelativeLocator.with(By.tagName("img")).above(seller));



    //3 ) Relative locator'larin dogru calistigini test edin
        if (nurse1.getAttribute("id").equals("nurs_thumb")){

            System.out.println("Nurse simgesi Passed");

        }else{
            System.out.println("Nurse simgesi failed");
        }
        driver.close();


    }
}
