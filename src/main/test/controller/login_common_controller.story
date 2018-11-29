Scenario: Simple test
Given a string, 'admin'
When the caller send string in controller
Then the controller is returned a null, because connection with db not allowed