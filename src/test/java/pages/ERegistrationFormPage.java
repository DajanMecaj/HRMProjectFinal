package pages;

import globals.globals;
import io.cucumber.java.bs.A;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseInformation;
import utilities.BasePageObject;
import elements.ERegistrationFormPageElements;
import java.time.Duration;
import java.util.List;

import static globals.globals.*;


public class ERegistrationFormPage {
    ERegistrationFormPageElements eRegistrationFormPageElements = new ERegistrationFormPageElements();
    WebDriverWait wait = new WebDriverWait(BaseInformation.getDriver(), Duration.ofSeconds(10));
    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());

    public void opemPIM() {
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.PIMbutton()).click();
    }

    public void fillinform() {
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.addemployeebtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.firstnameemployee()).sendKeys("Dajan");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.lastnameemployee()).sendKeys("Mecaj");
        System.out.println("Form filled");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.saveemployee()).click();
    }
    public void addemployee() throws InterruptedException {
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.addemployeebtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.firstnameemployee()).sendKeys("Dajan");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.lastnameemployee()).sendKeys("Mecaj");
        Thread.sleep(1000);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createlogindetailsbtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createemployeeusername()).sendKeys("dmecaj");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createemployeepassword()).sendKeys(createpassword);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createemployeepassword1()).sendKeys(createpassword);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.saveemployee()).click();
    }
    public void registrationsuccessfully(){
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.registrationsuccessfully()).isDisplayed();
        System.out.println("Employee added successfully");
    }
    public void invaliddetails() throws  InterruptedException{
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.addemployeebtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.firstnameemployee()).sendKeys("Dajan");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.lastnameemployee()).sendKeys("Mecaj");
        Thread.sleep(1000);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createlogindetailsbtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createemployeeusername()).sendKeys("dmecaj");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createemployeepassword()).sendKeys(invalidpassword);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.createemployeepassword1()).sendKeys(invalidpassword);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.saveemployee()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.invaliddetails()).isDisplayed();
            System.out.println("Invalid Details");


    }
    public void openEmployeelist(){
       basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.employeelistbtn()).click();
    }
    public void searchEmployee() throws InterruptedException {
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.searchEmployee()).sendKeys(searchemployee);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.saveemployee()).click();
        Thread.sleep(1000);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.searchEmployeeResult()).isDisplayed();


    }
    public void updateemployee() throws InterruptedException{
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.updatebtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.firstnameemployee()).sendKeys(searchemployee+"1");
        Actions actions = new Actions(BaseInformation.getDriver());
        actions.moveToElement(eRegistrationFormPageElements.saveeditedemployee());
        Thread.sleep(1000);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.saveeditedemployee()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.registrationsuccessfully()).isDisplayed();
        System.out.println("Employee edited successfully");
        String actualText = eRegistrationFormPageElements.firstnameemployee().getText();
        Assert.assertEquals(actualText, searchemployee +"1", "Text did not change as expected");
    }
    public void deleteemployee() throws InterruptedException {

        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.trashbtn()).click();
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.confirmdeletion());
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.registrationsuccessfully()).isDisplayed();
        System.out.println("Employee deleted successfully");
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.searchEmployee()).sendKeys(searchemployee);
        basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.saveemployee()).click();
        Thread.sleep(1000);
        if(!basePageObject.getWaitUtils().waitForElementVisible(eRegistrationFormPageElements.searchEmployeeResult()).isDisplayed()){
            System.out.println("Confirmed Deletion");
        };

    }


}

