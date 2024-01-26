package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;
import utilities.WebElementUtils;

public class dashboardPageElements {
    public dashboardPageElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    public WebElement  adminmodule(){
         return BaseInformation.getDriver().findElement(By.cssSelector("a[href=\"/web/index.php/admin/viewAdminModule\"]"));
    }
    public WebElement alerterror(){
        return  BaseInformation.getDriver().findElement(By.cssSelector(".oxd-alert"));

    }

}
