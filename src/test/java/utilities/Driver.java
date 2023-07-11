package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    private Driver(){

    }

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

        /*
            isyerimizde calisirken
            testlerimizi farkli browser'lar ile calistirmamiz istenebilir.
            Dinamik olarak browser kullanabilmek icin
            configuration.properties dosyamizda browser = istenenBrowser
            seklinde browser'i tanimladik

            Driver class'inda da configuration.properties dosyasindaki
            bilgiyi okuyup, o bilgiye gore istenen browser'i olusturacak
            bir yapi hazirlayalim
         */



        if(driver == null) {

            String browser = ConfigReader.getProperty("browser");

            switch (browser){

                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver=new SafariDriver();
                    break;
                case "edge"  :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }



        return driver;
    }


    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }

    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
