package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) {
        //1. Launch browser
        System.setProperty("webdriver.chrome.driver","kurulumDosyalari/chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

       // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
       // 3. Verify that home page is visible successfully
        String expectedTitle="Automation Exercise";
        String actualTitle= driver.getTitle();
        if (expectedTitle.equals(actualTitle)){
            System.out.println("Homepage görünürlük testi Passed");
        }else{
            System.out.println("Homepage görünürlük testi Failed");
        }
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();

        // 5. Verify 'New User Signup!' is visible

        String expectedMesaj="New User Signup!";
        String actualMesaj= driver.findElement(By.xpath("//h2[text()='New User Signup!']")).getText();
        if (expectedMesaj.equals(actualMesaj)){
            System.out.println("Yeni kayit bölümü görünürlük testi Passed");
        }else{
            System.out.println("Yeni kayit bölümü görünürlük testi Failed");
        }

        // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("umit");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("1umit1111@cemal.com");

        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        String expectedAccount="ENTER ACCOUNT INFORMATION";
        String actualAccount= driver.findElement(By.xpath("//b[text()='Enter Account Information']")).getText();
        if (expectedAccount.equals(actualAccount)){
            System.out.println("Account bölümü görünürlük testi Passed");
        }else{
            System.out.println("Account bölümü görünürlük testi Failed");
        }

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password123");
        driver.findElement(By.xpath("//select[@id='days']")).sendKeys("1");
        driver.findElement(By.xpath("//select[@id='months']")).sendKeys("May");
        driver.findElement(By.xpath("//select[@id='years']")).sendKeys("1998");


        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        // 11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//label[@for='optin']")).click();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("ali");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("veli");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("aliveli");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("ali mah.");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("veli cad.");
        driver.findElement(By.xpath("//select[@data-qa='country']")).sendKeys("Canada");
        driver.findElement(By.xpath("//input[@data-qa='state']")).sendKeys("Toronto");
        driver.findElement(By.xpath("//input[@data-qa='city']")).sendKeys("Ontorio");
        driver.findElement(By.xpath("//input[@data-qa='zipcode']")).sendKeys("12345");
        driver.findElement(By.xpath("//input[@data-qa='mobile_number']")).sendKeys("0535 111 11 11");

        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible
        String expectedAccountCread="ACCOUNT CREATED!";
        String actualAccountCread= driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
        if (expectedAccountCread.equals(actualAccountCread)){
            System.out.println("Account Cread bölümü görünürlük testi Passed");
        }else{
            System.out.println("Account Cread bölümü görünürlük testi Failed");
        }

        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();

        // 16. Verify that 'Logged in as username' is visible

        String expectedLogged="ACCOUNT DELETED!";
        String actualLogged= driver.findElement(By.xpath("//i[@class='fa fa-home']")).getText();
        if (expectedLogged.equals(actualLogged)){
            System.out.println("Logged bölümü görünürlük testi Passed");
        }else{
            System.out.println("Logged bölümü görünürlük testi Failed");
        }


        // 17. Click 'Delete Account' button
        driver.findElement(By.partialLinkText("/logout")).click();
        //driver.findElement(By.partialLinkText("delete account")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        String expectedAccountDeleted="ACCOUNT DELETED!";
        String actualAccountDeleted= driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).getText();
        if (expectedAccountDeleted.equals(actualAccountDeleted)){
            System.out.println("Account Delete bölümü görünürlük testi Passed");
        }else{
            System.out.println("Account Delete bölümü görünürlük testi Failed");
        }
        driver.findElement(By.xpath("//h2[@data-qa='account-deleted']")).click();

        driver.close();


    }
}
