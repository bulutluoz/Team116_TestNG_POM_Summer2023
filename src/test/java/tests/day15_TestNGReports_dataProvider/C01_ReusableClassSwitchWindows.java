package tests.day15_TestNGReports_dataProvider;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_ReusableClassSwitchWindows {

    @Test
    public void switchWindowTesti(){

        //https://the-internet.herokuapp.com/windows adresine gidin.
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //Click Here butonuna basın.
        Driver.getDriver().findElement(By.xpath("//a[text()='Click Here']")).click();

        //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

        ReusableMethods.switchToWindow("New Window");

        String expectedTitle = "New Window";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        // sayfalari kapatin
        Driver.quitDriver();


    }
}
