package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IntroAndRegistrationPage extends BasePage {

    @FindBy(className = "seperator-link")
    public WebElement registrationButton;
    @FindBy(css = "div.login-error")
    public WebElement error;
    @FindBy(css="[placeholder=\"אימות סיסמה\"]")
    public WebElement passwordVerification;
    @FindBy(css = "[gtm=\"הרשמה ל-BUYME\"]")
    public WebElement signInButton;
    @FindBy(css = "[placeholder=\"שם פרטי\"]")
    public WebElement firstName;
    @FindBy(css = "[placeholder=\"מייל\"]")
    public WebElement email;
    @FindBy(css = "[placeholder=\"סיסמה\"]")
    public WebElement password;
    @FindBy(css = "[gtm=\"כניסה ל-BUYME\"]")
    public WebElement loginButton;

    public IntroAndRegistrationPage(WebDriver driver) {
        super(driver);
    }
}
