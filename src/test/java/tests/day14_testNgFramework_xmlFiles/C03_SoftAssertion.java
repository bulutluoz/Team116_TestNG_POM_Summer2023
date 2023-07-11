package tests.day14_testNgFramework_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_SoftAssertion {

    @Test(groups = "mini regression1")
    public void nutellaTesti(){

        // amazona gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // 1- Soft Assert kullanmak icin obje olusturmaliyiz
        SoftAssert softAssert = new SoftAssert();
        // 2- istediginiz tum testleri softAssert objesini kullanarak yapin

        // title'in best icermedigini test edin
        String unexpectedIcerik = "best";
        String actualTitle = Driver.getDriver().getTitle();

        softAssert.assertFalse(actualTitle.contains(unexpectedIcerik),"Title istenmeyen icerik barindiriyor");

        // url'in "https://www.amazon.com/" oldugunu test edin
        String expectedUrl = "https://www.amazon.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();

        softAssert.assertEquals(actualUrl,expectedUrl,"Url beklenenden farkli");

        //Nutella aratin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edin
        String expectedUrunIcerik = "Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();
        softAssert.assertTrue(actualSonucYazisi.contains(expectedUrunIcerik),"sonuclar Nutella icermiyor");

        // 3- Tum testlerimiz bittiginde
        //    softAssert objesinin not aldigi hatalari raporlamasini isteyelim

        softAssert.assertAll();
        /*
            softAssert.assertAll(); komutu
            yukarda yapilan tum testleri raporlar
            ve
            failed olan herhangi bir assertion varsa
            AssertionError verip calismayi durdurur

            ancak tum hatalari assertAll() satirinda verir
            hatalarin yerini bulmamiz ve duzeltmemiz icin
            softassert ile yapilan assertion'larda
            Mutlaka aciklama yazilmalidir
         */

        Driver.closeDriver();

    }
}
