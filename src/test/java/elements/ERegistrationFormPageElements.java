package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.BaseInformation;

import java.util.List;

public class ERegistrationFormPageElements {
    public ERegistrationFormPageElements(){
        PageFactory.initElements(BaseInformation.getDriver(),this);
    }

    public WebElement PIMbutton(){
        return BaseInformation.getDriver().findElement(By.cssSelector("a[href=\"/web/index.php/pim/viewPimModule\"]"));
    }
    public WebElement addemployeebtn(){
        return BaseInformation.getDriver().findElement(By.xpath("//a[contains(text(),'Add Employee')]"));
    }
    public WebElement employeelistbtn(){
        return BaseInformation.getDriver().findElement(By.xpath("//a[contains(text(),'Employee List')]"));
    }
    public WebElement trashbtn(){
        return BaseInformation.getDriver().findElement(By.cssSelector("i.bi-trash"));
    }
    public WebElement confirmdeletion(){
        return BaseInformation.getDriver().findElement(By.cssSelector(".oxd-button--label-danger"));
    }
    public WebElement searchEmployee(){
        return BaseInformation.getDriver().findElement(By.xpath("(//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--active']//input)[1]"));
    }
    public WebElement updatebtn(){
        return BaseInformation.getDriver().findElement(By.cssSelector("i.bi-pencil-fill"));
    }
    public WebElement searchEmployeeResult(){
        return BaseInformation.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div"));
    }
    public WebElement firstnameemployee(){
        return BaseInformation.getDriver().findElement(By.cssSelector("input[name=\"firstName\"]"));
    }
    public WebElement lastnameemployee(){
        return BaseInformation.getDriver().findElement(By.cssSelector("input[name=\"lastName\"]"));
    }
    public WebElement createlogindetailsbtn(){
        return BaseInformation.getDriver().findElement(By.cssSelector("label[data-v-8e4757dc] .oxd-switch-input"));
    }
    public WebElement createemployeeusername(){
        return BaseInformation.getDriver().findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
    }
    public WebElement createemployeepassword(){
        return BaseInformation.getDriver().findElement(By.xpath("(//input[@type='password'])[1]"));
    }
    public WebElement createemployeepassword1(){
        return BaseInformation.getDriver().findElement(By.xpath("(//input[@type='password'])[2]"));
    }
    public WebElement saveemployee(){
        return BaseInformation.getDriver().findElement(By.cssSelector("button[type=\"submit\"]"));
    }
    public WebElement saveeditedemployee(){
        return BaseInformation.getDriver().findElement(By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' and @data-v-10d463b7=''])[1]"));
    }
    public WebElement registrationsuccessfully(){
        return BaseInformation.getDriver().findElement(By.cssSelector("div.oxd-toast.oxd-toast--success"));
    }
    public WebElement invaliddetails(){
        return BaseInformation.getDriver().findElement(By.cssSelector("span.oxd-text.oxd-text--span.oxd-input-field-error-message"));
    }
}
