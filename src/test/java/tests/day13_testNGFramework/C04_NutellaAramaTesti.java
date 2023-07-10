package tests.day13_testNGFramework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NutellaAramaTesti {

    @Test
    public void test01(){

        // amazon anasayfaya gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonArananKelime")+ Keys.ENTER);

        // sonuclarin Nutella icerdigini test edin

        String expectedIcerik = ConfigReader.getProperty("amazonArananKelime");
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        // sayfayi kapatin

        Driver.closeDriver();
    }
}
