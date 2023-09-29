package uistore;

import org.openqa.selenium.By;

public class WithdrawPageUi {
    public static By withdrawAccountDropDown = By.id("selectedAccount");
    public static By withdrawAmount = By.id("amount");
    public static By submitButton = By.xpath("//button[text()=' Submit']");
}