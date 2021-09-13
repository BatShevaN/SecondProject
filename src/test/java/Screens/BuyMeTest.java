package Screens;

import Pages.BuyMePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.UUID;

public class BuyMeTest {

// ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter;
//ExtentReports extent= new ExtentReports();
//ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C://Users//extent.html");
//extent.attachReporter(htmlReporter);


    public static String getData(String keyName) throws Exception {
        File fXmlFile = new File("src/test/java/test.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeMethod
    public void startDriver() throws Exception {

        DriverFactory.getDriverInstance().get(getData("URL"));
    }

    @AfterMethod
    public void closeDriver(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) DriverFactory.getDriverInstance()).getScreenshotAs(OutputType.FILE);
            String fileName = UUID.randomUUID().toString();
            File targetFile = new File("./Screenshots/" + fileName + ".png");
            FileUtils.copyFile(scrFile, targetFile);
        }
        DriverFactory.getDriverInstance().quit();
    }

    @Test(description = "creating a new user into the system.")
    public void createNewUser() throws Exception {
        BuyMePage buyMePage = new BuyMePage(DriverFactory.getDriverInstance());
        buyMePage.registrationButton.click();
        Thread.sleep(5000);
        DriverFactory.getDriverInstance().findElements(By.className("text-link")).get(0).click();
        buyMePage.firstName.sendKeys("Ran");
        Thread.sleep(5000);
        buyMePage.email.sendKeys("Ran123@gmail.com");
        buyMePage.password.sendKeys("Ran123456");
        buyMePage.passwordVerification.sendKeys("Ran123456");
        buyMePage.signInButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(buyMePage.error.getText(), "דוא\"ל זה כבר קיים במערכת.");
//test.log(Status.PASS, “<The user will be created into the system>");
    }

    public void logIn() throws Exception {
        BuyMePage buyMePage = new BuyMePage(DriverFactory.getDriverInstance());
        buyMePage.registrationButton.click();
        Thread.sleep(5000);
        buyMePage.email.sendKeys("Ran123@gmail.com");
        buyMePage.password.sendKeys("Ran123456");
        buyMePage.loginButton.click();
//test.log(Status.PASS , “<The user logs into the system with a username that already definded in the system>");
    }

    @Test(description = "Searching in Tel Aviv location presents'.")
    public void BuyMeTest() throws Exception {
        BuyMePage buyMePage = new BuyMePage(DriverFactory.getDriverInstance());
        logIn();
        Thread.sleep(5000);
        buyMePage.clickOnSumButton.get(0).click();
        Thread.sleep(5000);
        buyMePage.choosingCategory.get(1).click();
        buyMePage.clickOnSumButton.get(1).click();
        buyMePage.choosingCategory.get(1).click();
        buyMePage.clickOnSumButton.get(2).click();
        buyMePage.choosingCategory.get(1).click();
        DriverFactory.getDriverInstance().findElements(By.cssSelector("[rel=nofollow]")).get(0).click();
        Thread.sleep(5000);
        Assert.assertEquals(DriverFactory.getDriverInstance().getCurrentUrl(), "https://buyme.co.il/search?budget=1&category=76&region=13");
        DriverFactory.getDriverInstance().findElements(By.className("top")).get(1).click();
        Thread.sleep(5000);
        buyMePage.enterSum.sendKeys("40");
        Thread.sleep(5000);
        buyMePage.selectButton.click();
        Thread.sleep(5000);
        buyMePage.freindNameInput.clear();
        buyMePage.freindNameInput.sendKeys("Batsheva");
        Thread.sleep(5000);
//        Assert.assertEquals(buyMePage.freindNameInput.getText(),"Batsheva", "שם מקבל המתנה אינו נכון");
        buyMePage.selectedEvent.click();
        Thread.sleep(5000);
        buyMePage.selectOption.get(17).click();
        buyMePage.blesingInput.clear();
        buyMePage.blesingInput.sendKeys("שנה טובה ומבורכת");
        buyMePage.uploadImage.sendKeys("C:\\Users\\USER\\Downloads\\1.jpeg");
        Thread.sleep(5000);
        buyMePage.continuoButton.click();
        buyMePage.howToSendGift.get(1).click();
        Thread.sleep(5000);
        buyMePage.emailReseverName.sendKeys("batshevat770@gmail.com");
//        Assert.assertEquals(buyMePage.emailReseverName.getText(),"batshevat770@gmail.com", "אימייל מקבל המתנה");
//        Assert.assertEquals(buyMePage.freindNameInput.getText(),"Ran", "שם שולח המתנה");
// test.log(Status.PASS, “<Searching for a gift in Tel Aviv area,select amount,area,category of gift, and press a button:
// "find me a gift",choose the desired place. enter the desired amount, and fill in all the fields with the details of
// the sender and the receiver name.>");


// Methods:
// getData() = Which get the data from the xml, and eventually the browser will open in the confiuguration in the xml file.

// setUpDriver() = Witch set up the driver in the system to be available throught all running the program.

// startDriver() = Witch open the carrent URL (that definded in xml).

//closeDriver() = Witch closing the driver and take a screenshot.

// createNewUser() = Witch creating a new user into the system,(where registering a new user into the system.)

// logIn() = Witch login the user into the system.

// BuyMeTest() = Witch Searching for a gift in Tel Aviv area,select amount,area,category of gift, and press a button:
// "find me a gift",choose the desired place. enter the desired amount, and fill in all the fields with the details of
// the sender and the receiver name.


    }
}


