package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.*;
import utilities.DriverSingleton;
import utilities.XMLReader;

import java.io.File;
import java.lang.reflect.Method;
import java.util.UUID;

public class BuyMeTest {
    ExtentReports extentReports;
    ExtentTest test;
    ExtentSparkReporter htmlReporter;

    @BeforeClass
    public void setUpDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        extentReports = new ExtentReports();
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir"));
    }

    @BeforeMethod
    public void startDriver(Method method) throws Exception {
        DriverSingleton.getDriverInstance().get(XMLReader.getData("URL"));
        test = extentReports.createTest(method.getName());
    }

    @AfterMethod
    public void closeDriver(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            File scrFile = ((TakesScreenshot) DriverSingleton.getDriverInstance()).getScreenshotAs(OutputType.FILE);
            String fileName = UUID.randomUUID().toString();
            File targetFile = new File("./Screenshots/" + fileName + ".png");
            FileUtils.copyFile(scrFile, targetFile);
        }
        WebStorage webStorage = (WebStorage) DriverSingleton.getDriverInstance();
        webStorage.getSessionStorage().clear();
        webStorage.getLocalStorage().clear();
        DriverSingleton.getDriverInstance().manage().deleteAllCookies();
        DriverSingleton.getDriverInstance().get(XMLReader.getData("URL"));
    }

    @AfterClass
    public void after() throws Exception {
        extentReports.attachReporter(htmlReporter);
        extentReports.flush();
        DriverSingleton.getDriverInstance().quit();
    }

    @Test(description = "creating a new user into the system.")
    public void createNewUser() throws Exception {
        IntroAndRegistrationPage introAndRegistrationPage = new IntroAndRegistrationPage(DriverSingleton.getDriverInstance());
        introAndRegistrationPage.registrationButton.click();
        Thread.sleep(5000);
        DriverSingleton.getDriverInstance().findElements(By.className("text-link")).get(0).click();
        introAndRegistrationPage.firstName.sendKeys("Ran");
        Thread.sleep(5000);
        introAndRegistrationPage.email.sendKeys("Ran123@gmail.com");
        introAndRegistrationPage.password.sendKeys("Ran123456");
        introAndRegistrationPage.passwordVerification.sendKeys("Ran123456");
        introAndRegistrationPage.signInButton.click();
        Thread.sleep(5000);
        Assert.assertEquals(introAndRegistrationPage.error.getText(), "דוא\"ל זה כבר קיים במערכת.");
    }

    public void logIn() throws Exception {
        IntroAndRegistrationPage introAndRegistrationPage = new IntroAndRegistrationPage(DriverSingleton.getDriverInstance());
        introAndRegistrationPage.registrationButton.click();
        Thread.sleep(5000);
        introAndRegistrationPage.email.sendKeys("Ran123@gmail.com");
        introAndRegistrationPage.password.sendKeys("Ran123456");
        introAndRegistrationPage.loginButton.click();
    }

    @Test(description = "Searching in Tel Aviv location presents'.")
    public void BuyMeTest() throws Exception {
        HomePage homePage = new HomePage(DriverSingleton.getDriverInstance());
        SenderReceiverInformationPage senderReceiverInformationPage = new SenderReceiverInformationPage(DriverSingleton.getDriverInstance());
        PickBusinessPage pickBusinessPage = new PickBusinessPage(DriverSingleton.getDriverInstance());
        test.log(Status.PASS, "some status");
        logIn();
        Thread.sleep(5000);
        homePage.clickOnSumButton.get(0).click();
        Thread.sleep(5000);
        homePage.choosingCategory.get(1).click();
        homePage.clickOnSumButton.get(1).click();
        homePage.choosingCategory.get(1).click();
        homePage.clickOnSumButton.get(2).click();
        homePage.choosingCategory.get(1).click();
        DriverSingleton.getDriverInstance().findElements(By.cssSelector("[rel=nofollow]")).get(0).click();
        Thread.sleep(5000);
        Assert.assertEquals(DriverSingleton.getDriverInstance().getCurrentUrl(), "https://buyme.co.il/search?budget=1&category=76&region=13");
        DriverSingleton.getDriverInstance().findElements(By.className("top")).get(1).click();
        Thread.sleep(5000);
        pickBusinessPage.enterSum.sendKeys("40");
        Thread.sleep(5000);
        pickBusinessPage.selectButton.click();
        Thread.sleep(5000);
        senderReceiverInformationPage.freindNameInput.clear();
        senderReceiverInformationPage.freindNameInput.sendKeys("Batsheva");
        Thread.sleep(5000);
        senderReceiverInformationPage.selectedEvent.click();
        Thread.sleep(5000);
        senderReceiverInformationPage.selectOption.get(17).click();
        senderReceiverInformationPage.blesingInput.clear();
        senderReceiverInformationPage.blesingInput.sendKeys("שנה טובה ומבורכת");
        senderReceiverInformationPage.uploadImage.sendKeys("C:\\Users\\USER\\Downloads\\1.jpeg");
        Thread.sleep(5000);
        senderReceiverInformationPage.continuoButton.click();
        senderReceiverInformationPage.howToSendGift.get(1).click();
        Thread.sleep(5000);
        senderReceiverInformationPage.emailReseverName.sendKeys("batshevat770@gmail.com");
    }
}