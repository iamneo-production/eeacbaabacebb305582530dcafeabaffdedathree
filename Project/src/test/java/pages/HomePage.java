package pages;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import uistore.HomePageUi;
import utils.WebDriverHelper;

public class HomePage {
    private WebDriver driver;
    private WebDriverHelper helper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        helper = new WebDriverHelper(driver);
    }

    public void clickDepositLinkText() throws Exception {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(HomePageUi.depositLinkText));
        helper.clickElement(HomePageUi.depositLinkText);
    }

    public void clickWithdrawLinkText() throws Exception {
        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(HomePageUi.withdrawLinkText));
        helper.clickElement(HomePageUi.withdrawLinkText);
    }
}
