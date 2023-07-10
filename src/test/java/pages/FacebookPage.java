package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailKutuElementi;

    @FindBy(id="pass")
    public WebElement passwordKutuElementi;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement girisYapButonu;

    @FindBy(xpath = "//*[@title='Decline optional cookies']")
    public WebElement cookiesButton;

    @FindBy(xpath = "//*[@class='_9ay7']")
    public WebElement basarisizGirisyaziElementi;

}
