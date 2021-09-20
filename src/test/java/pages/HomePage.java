package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "chosen-single")
    public List<WebElement> clickOnSumButton;

    @FindBy(className = "active-result")
    public List<WebElement> choosingCategory;
}
