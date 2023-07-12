package tests.day15_TestNGReports_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C02_RaporluNutellaTesti extends TestBaseRapor {

    @Test
    public void raporluTest() {

        extentTest = extentReports.createTest("Raporlu Nutella arama","Kullanici amazonda Nutella arayabilmeli");

        // amazona gidin

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("Kullanici amazon anasayfaya gider");
        // Nutella icin arama yapin
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        extentTest.info("Kullanici Nutella icin arama yapar");
        // sonuclarin Nutella icerdigini test edin

        String expectedIcerik ="Nutella";
        String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        extentTest.pass("Sonuclarin Nutella icerdigini test eder");
        // sayfayi kapatin

        Driver.closeDriver();

    }
}
