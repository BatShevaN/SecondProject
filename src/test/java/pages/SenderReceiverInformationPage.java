package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SenderReceiverInformationPage extends BasePage{
    public SenderReceiverInformationPage(WebDriver driver) {
        super(driver);
    }

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
}
