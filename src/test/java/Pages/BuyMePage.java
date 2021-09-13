package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BuyMePage {
    WebDriver driver;

    @FindBy(className = "seperator-link")
    public WebElement registrationButton;
    @FindBy(css = "[placeholder=\"מייל\"]")
    public WebElement email;
    @FindBy(css = "[placeholder=\"סיסמה\"]")
    public WebElement password;

    @FindBy(css = "div.login-error")
    public WebElement error;

    @FindBy(css="[placeholder=\"אימות סיסמה\"]")
    public WebElement passwordVerification;
    @FindBy(css = "[gtm=\"כניסה ל-BUYME\"]")
    public WebElement loginButton;
    @FindBy(css = "[gtm=\"הרשמה ל-BUYME\"]")
    public WebElement signInButton;

    @FindBy(className = "chosen-single")
    public List<WebElement> clickOnSumButton;

    @FindBy(className = "active-single")
    public List<WebElement> choosingSum;

    @FindBy(className = "chosen-single")
    public List<WebElement> choosingSite;

    @FindBy(className = "active-result")
    public List<WebElement> choosingCategory;

    @FindBy(className = "chosen-single")
    public List<WebElement> findMeGiftButton;



    @FindBy(css = "[placeholder=\"שם פרטי\"]")
    public WebElement firstName;

    @FindBy(css = "[placeholder=\"הכנס סכום\"]")
    public WebElement enterSum;

    @FindBy(css = "[gtm=\"בחירה\"]")
    public WebElement selectButton;

    @FindBy(css = "[id=friendName] input")
    public WebElement freindNameInput;

    @FindBy(css ="[alt=\"לאיזה אירוע?\"]")
    public WebElement selectedEvent;

    @FindBy(className =("bm-select-option"))
    public List<WebElement> selectOption;

    @FindBy(css =("[placeholder=\"מזל טוב, תודה רבה או פשוט מלא אהבה? כאן כותבים מילים טובות ואיחולים שמחים\"]"))
    public WebElement blesingInput;

    @FindBy(css =("[type=file]"))
    public WebElement uploadImage;

    @FindBy(css =("[gtm=\"המשך\"]"))
    public WebElement continuoButton;

    @FindBy(className =("toggle-icon"))
    public  List<WebElement> howToSendGift;

    @FindBy(css =("[placeholder=\"מייל מקבל/ת המתנה\"]"))
    public WebElement emailReseverName;










    public BuyMePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
