package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import uistore.DepositPageUi;
import uistore.WithdrawPageUi;
import utils.WebDriverHelper;

public class WithdrawPage {
    private WebDriver driver;
    private WebDriverHelper helper;

    public WithdrawPage(WebDriver driver) {
        this.driver = driver;
        helper = new WebDriverHelper(driver);
    }

    public void selectItemFromDepositDropDown() throws Exception {
        Actions action = new Actions(driver);
        WebElement element = driver.findElement(WithdrawPageUi.withdrawAccountDropDown);
        action.moveToElement(element).click().sendKeys(Keys.DOWN).sendKeys(Keys.RETURN).perform();
    }

    public void sendWithdrawAmount(String amount) throws Exception {
        helper.fillForm(WithdrawPageUi.withdrawAmount, amount);
    }

    public void clickSubmitButton() throws Exception {
        helper.clickElement(WithdrawPageUi.submitButton);
    }
}
