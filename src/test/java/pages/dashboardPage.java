package pages;

import elements.dashboardPageElements;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseInformation;
import utilities.BasePageObject;

import java.time.Duration;

public class dashboardPage {
    dashboardPageElements dashboardPageElements = new dashboardPageElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());

    public void confirmdashboardPage() {
        String title = BaseInformation.getDriver().getCurrentUrl();
        Assert.assertEquals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", title);
        System.out.println("We are at the Dashboard Page.");
    }

    public void checkuserrole() {
        basePageObject.getWaitUtils().waitForElementVisible(dashboardPageElements.adminmodule());
        if (dashboardPageElements.adminmodule().isDisplayed()) {
            System.out.println("You're an admin");
        }
        else{
            System.out.println("You're an employee");
        }
    }
    public void adminfunctionalitiespage(){
        BaseInformation.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");

    }
    public void alerterror(){
        if(dashboardPageElements.alerterror().isDisplayed()){
            System.out.println("You're not an admin.");
        }
    }
}
