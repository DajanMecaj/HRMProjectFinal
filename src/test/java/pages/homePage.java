package pages;

import elements.homePageElements;
import globals.globals;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseInformation;
import utilities.BasePageObject;

import java.time.Duration;

import static globals.globals.*;



public class homePage {
    homePageElements homePageElements = new homePageElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    public void setHomepage(){
        BaseInformation.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    public void confirmhomePage(){
        String title = BaseInformation.getDriver().getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",title);
        System.out.println("We are at the homepage.");
    }
    public void adminlogin(){
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.username()).click();
        basePageObject.getWebElementUtils().sendKeysToElementWithWait(homePageElements.username(),adminusername,10);
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.password()).click();
        basePageObject.getWebElementUtils().sendKeysToElementWithWait(homePageElements.password(),adminpassword,10);
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.loginbtn()).click();

    }
    public void employeelogin(){
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.username());
        basePageObject.getWebElementUtils().clickWebElement(homePageElements.username());
        basePageObject.getWebElementUtils().sendKeysToElementWithWait(homePageElements.username(),employeeusername,10);
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.password());
        basePageObject.getWebElementUtils().clickWebElement(homePageElements.password());
        basePageObject.getWebElementUtils().sendKeysToElementWithWait(homePageElements.password(),employeepassword,10);
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.loginbtn());
        basePageObject.getWebElementUtils().clickWebElement(homePageElements.loginbtn());

    }
    public void managerlogin(){
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.username());
        basePageObject.getWebElementUtils().clickWebElement(homePageElements.username());
        basePageObject.getWebElementUtils().sendKeysToElementWithWait(homePageElements.username(),managerusername,10);
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.password());
        basePageObject.getWebElementUtils().clickWebElement(homePageElements.password());
        basePageObject.getWebElementUtils().sendKeysToElementWithWait(homePageElements.password(),managerpassword,10);
        basePageObject.getWaitUtils().waitForElementVisible(homePageElements.loginbtn());
        basePageObject.getWebElementUtils().clickWebElement(homePageElements.loginbtn());

    }
}
