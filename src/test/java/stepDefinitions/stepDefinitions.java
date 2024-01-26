package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.ERegistrationFormPage;
import utilities.BaseInformation;
import pages.homePage;
import pages.dashboardPage;

public class stepDefinitions {
    WebDriver driver = BaseInformation.getDriver();
    homePage homePage = new homePage();
    dashboardPage dashboardPage = new dashboardPage();
    ERegistrationFormPage eRegistrationFormPage = new ERegistrationFormPage();
@Before
    @Given("the HRM system is open")
    public void the_hrm_system_is_open() {
    homePage.setHomepage();
    homePage.confirmhomePage();

    }
@After
    public void tearDown(){
    driver.quit();
    }


@Test
    @When("an admin logs in with valid credentials")
    public void an_admin_logs_in_with_valid_credentials() {
    homePage.adminlogin();

    }

    @Then("the admin is directed to the admin landing page")
    public void the_admin_is_directed_to_the_admin_landing_page() {
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
    }

    @When("a manager logs in with valid credentials")
    public void a_manager_logs_in_with_valid_credentials() {
        homePage.managerlogin();

    }

   @Then("the manager is directed to the manager landing page")
    public void the_manager_is_directed_to_the_manager_landing_page() {
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
    }

    @When("an employee logs in with valid credentials")
    public void an_employee_logs_in_with_valid_credentials() {
    homePage.employeelogin();
    }

    @Then("the employee is directed to the employee landing page")
    public void the_employee_is_directed_to_the_employee_landing_page() {
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
    }


    @Then("access is denied for unauthorized user")
    public void access_is_denied_for_unauthorized_user() {
        dashboardPage.alerterror();

    }
    @When("an employee tries to access admin functionalities")
    public void an_employee_tries_to_access_admin_functionalities() {
        homePage.employeelogin();
        dashboardPage.confirmdashboardPage();
        dashboardPage.adminfunctionalitiespage();

    }

    @When("an admin navigates to the employee registration form")
    public void an_admin_navigates_to_the_employee_registration_form() {
        homePage.adminlogin();
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
        eRegistrationFormPage.opemPIM();

    }

    @When("fills in the form with valid data")
    public void fills_in_the_form_with_valid_data() {
    eRegistrationFormPage.fillinform();

    }

    @Then("the system accepts the data")
    public void the_system_accepts_the_data() {
    eRegistrationFormPage.registrationsuccessfully();

    }

    @When("fills in the form with invalid data")
    public void fills_in_the_form_with_invalid_data() throws InterruptedException{
        eRegistrationFormPage.invaliddetails();

    }
    @When("an admin creates a new employee record with valid data")
    public void an_admin_creates_a_new_employee_record_with_valid_data() throws InterruptedException{
        homePage.adminlogin();
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
        eRegistrationFormPage.opemPIM();
        eRegistrationFormPage.addemployee();
    }

    @Then("the employee record is added successfully")
    public void the_employee_record_is_added_successfully() {
        eRegistrationFormPage.registrationsuccessfully();
    }

    @Given("an existing employee record")
    public void an_existing_employee_record()  throws InterruptedException {
        homePage.adminlogin();
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
        eRegistrationFormPage.opemPIM();
        eRegistrationFormPage.openEmployeelist();
        eRegistrationFormPage.searchEmployee();

    }

    @Then("an admin updates the employee information")
    public void an_admin_updates_the_employee_information() throws InterruptedException{
        eRegistrationFormPage.updateemployee();

    }

    @When("an admin deletes the employee record")
    public void an_admin_deletes_the_employee_record() throws InterruptedException {
        homePage.adminlogin();
        dashboardPage.confirmdashboardPage();
        dashboardPage.checkuserrole();
        eRegistrationFormPage.openEmployeelist();
        eRegistrationFormPage.searchEmployee();
        eRegistrationFormPage.deleteemployee();
        eRegistrationFormPage.registrationsuccessfully();

    }
}
