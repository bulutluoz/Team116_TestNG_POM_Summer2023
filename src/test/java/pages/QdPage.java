package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class QdPage {

    public QdPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath = "//*[@id='login-email']")
    public WebElement emailKutusu;

    @FindBy(xpath = "//*[@id='login-password']")
    public WebElement passwordKutusu;

    @FindBy(xpath = "//*[@class='btn red radius-5 mt-4 w-100']")
    public WebElement loginButonu;

    @FindBy(xpath = "(//a[text()='My courses'])[1]")
    public WebElement basariliGirisKontrolElementi;

}
