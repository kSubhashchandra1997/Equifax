Feature: Employee
  Scenario: Get employee details
    Given Hit the employees endpoint
    Then Validate the status code get employee

  Scenario: Create new employee
    Given Hit the create employee endpoint
    Then Validate the status code for create employee

