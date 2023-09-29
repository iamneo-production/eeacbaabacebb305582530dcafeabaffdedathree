package runner;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import pages.DepositPage;
import pages.HomePage;
import pages.SignInPage;
import pages.WithdrawPage;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class Test_dbankApplication extends Base {
    Logger log = LoggerHandler.getLogger();
    ExtentReports extentReport = Reporter.generateExtentReport();
    private SignInPage signInPage;
    private HomePage homePage;
    private DepositPage depositPage;
    private WithdrawPage withdrawPage;

    @BeforeMethod
    public void startUp() throws MalformedURLException {
        driver = openBrowser();
        signInPage = new SignInPage(driver);
        homePage = new HomePage(driver);
        depositPage = new DepositPage(driver);
        withdrawPage = new WithdrawPage(driver);
    }

    @Test(priority = 1)
    public void verifySignIn() throws IOException {
        ExtentTest test = extentReport.createTest("Registration Page", "Verify Sign In feature");
        try {

            signInPage.sendUserName("S@gmail.com");
            log.info("Sent User Name");
            signInPage.sendPassword("P@ssword12");
            log.info("Sent Password");
            signInPage.clickSubmitButton();
            log.info("Clicked Submit Button");
            test.pass("Sign In Verified Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            Screenshot.getScreenShot(driver, "Sign In");
            test.log(Status.FAIL, "Sign In Failed");
        }

    }

    @Test(priority = 2)
    public void verifyDeposit() throws IOException {
        ExtentTest test = extentReport.createTest("Home Page - Deposit", "Verify Deposit feature");
        try {
            signInPage.sendUserName("S@gmail.com");
            log.info("Sent User Name");
            signInPage.sendPassword("P@ssword12");
            log.info("Sent Password");
            signInPage.clickSubmitButton();
            log.info("Clicked Submit Button");

            homePage.clickDepositLinkText();
            log.info("Clicked Deposit link text clicked");

            depositPage.selectItemFromDepositDropDown();
            log.info("Selected Item from Deop Down List");

            depositPage.sendDepositAmount(null);
            log.info("Sent deposit amount text");
            depositPage.clickSubmitButton();
            log.info("Clicked Submit");
            test.pass("Sign In Verified Successfully");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            Screenshot.getScreenShot(driver, "Deposit");
            test.log(Status.FAIL, "Deposit Failed");
        }

    }

    @Test(priority = 3)
    public void verifyWithdraw() throws IOException {
        ExtentTest test = extentReport.createTest("Home Page - Withdraw", "Verify Withdraw feature");
        try {
            signInPage.sendUserName("S@gmail.com");
            log.info("Sent User Name");
            signInPage.sendPassword("P@ssword12");
            log.info("Sent Password");
            signInPage.clickSubmitButton();
            log.info("Clicked Submit Button");

            homePage.clickWithdrawLinkText();
            ;
            log.info("Clicked Withdraw link text clicked");

            withdrawPage.selectItemFromDepositDropDown();
            log.info("Selected Item from Drop Down List");

            withdrawPage.sendWithdrawAmount(null);
            log.info("Sent Withdraw amount text");
            withdrawPage.clickSubmitButton();
            log.info("Clicked Submit");
            test.pass("Withdraw Verified Successfully");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

            Screenshot.getScreenShot(driver, "Deposit");
            test.log(Status.FAIL, "Deposit Failed");
        }
    }

    // @DataProvider
    // public Object[][] readTestData(){

    // }
    @AfterMethod
    public void end() {
        driver.quit();
        extentReport.flush();
        log.info("Browser closed");
        LoggerHandler.closeHandler();
    }
}
