Feature: HRM System Testing

  Background:
    Given the HRM system is open

  # Task 1: Role-Based Access Control Testing
  Scenario: Successful Login and Access Control for Admin
    When an admin logs in with valid credentials
    Then the admin is directed to the admin landing page

 # Scenario: Successful Login and Access Control for Manager
  #  When a manager logs in with valid credentials
   # Then the manager is directed to the manager landing page

  Scenario: Successful Login and Access Control for Employee
    When an employee logs in with valid credentials
    Then the employee is directed to the employee landing page

  Scenario: Unauthorized Access Attempt to Admin Functionalities by Employee
    When an employee tries to access admin functionalities
    Then access is denied for unauthorized user

  # Task 2: Data Validation and CRUD Operations Testing
  Scenario: Data Validation - Successful Input
    When an admin navigates to the employee registration form
    And fills in the form with valid data
    Then the system accepts the data

  Scenario: Data Validation - Invalid Input Rejection
    When an admin navigates to the employee registration form
    Then fills in the form with invalid data

  Scenario: Create New Employee Record
    When an admin creates a new employee record with valid data
    Then the employee record is added successfully

  Scenario: Update Existing Employee Information
    Given an existing employee record
    Then an admin updates the employee information

  Scenario: Delete Existing Employee Record
    Given an existing employee record
    When an admin deletes the employee record
