package pages;

import org.openqa.selenium.WebDriver;

import uistore.SignInPageUi;
import utils.WebDriverHelper;

public class SignInPage{
    private WebDriver driver;
    private WebDriverHelper helper;
    public SignInPage(WebDriver driver){
        this.driver = driver;
        helper = new WebDriverHelper(driver);
    }

    public void verifySignInPageHeader(){

    }
    public void sendUserName(String userName) throws Exception {
        helper.fillForm(SignInPageUi.userName, userName);
    }
    public void sendPassword(String password) throws Exception {
        helper.fillForm(SignInPageUi.password, password);
    }
    public void clickSubmitButton() throws Exception{
        helper.clickElement(SignInPageUi.submitButton);
    }
    
}
