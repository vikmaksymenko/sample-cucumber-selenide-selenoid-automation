Feature: Test that fails

  Scenario: When user type email to forgot password, email should be sent
    When  navigate to "/forgot_password"
    When  type "test@test.com"
    And   push "Retrieve password"
    Then  message "Your e-mail's been sent TO HELL!" should be displayed
