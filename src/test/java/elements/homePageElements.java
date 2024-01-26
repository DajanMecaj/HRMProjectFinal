package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

public class homePageElements {
    public homePageElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }
    public WebElement username(){
        return BaseInformation.getDriver().findElement(By.cssSelector("input[name=\"username\"]"));
    }
    public WebElement password(){
        return BaseInformation.getDriver().findElement(By.cssSelector("input[name=\"password\"]"));
    }
    public WebElement loginbtn(){
        return BaseInformation.getDriver().findElement(By.cssSelector("button[type=submit]"));
    }

}
