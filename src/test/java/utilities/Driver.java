package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        /*
            Bundan sonra daha once driver olarak TestBase'den alip kullandigimiz
            WEbDriver'in yerine

            Driver class'indan getDriver()'unu kullanacagiz
            ancak mahserin dort atlisinda kullandigimiz

            driver= new ChromeDriver();

            problem olusturuyor, cunku her calistiginda yeniden bir ChromeDriver olusturuyor

            Bizim istedigimiz sey su :

            ben testimiz calistirmaya basladigimda
            ilk kez bu method'u kullaninca ChromeDriver olustursun
            sonraki kullanimlarda olusturmasin

            bunun icin driver == null kontrol edip
            ona gore yeni ChromeDriver atamasi yapiyoruz

         */

        WebDriverManager.chromedriver().setup();


        if(driver == null) {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }


    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
