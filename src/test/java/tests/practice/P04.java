package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P04 {
    public static void main(String[] args) {
        /* ...Exercise3...
         Navigate to  https://testpages.herokuapp.com/styled/index.html
         Click on  Calculater under Micro Apps
         Type any number in the first input
         Type any number in the second input
         Click on Calculate
         Get the result
         Print the result
  */


        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        driver.findElement(By.id("calculatetest")).click(); // By id dedigimiz icin id degerini aldik sadece
        driver.findElement(By.id("number1")).sendKeys("20");
        driver.findElement(By.id("number2")).sendKeys("40");
        driver.findElement(By.id("calculate")).click();
        // veya driver.findElement(By.className("styled-click-button")).click();
        // class name ile de calculate elementine gidebiliriz.Onemli olan uniq bir deger olmasi

        System.out.println("20+40:"+driver.findElement(By.id("answer")).getText());

        driver.close();

    }
}
