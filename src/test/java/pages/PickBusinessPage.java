package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PickBusinessPage  extends BasePage{
    public PickBusinessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[placeholder=\"הכנס סכום\"]")
    public WebElement enterSum;
    @FindBy(css = "[gtm=\"בחירה\"]")
    public WebElement selectButton;

}
