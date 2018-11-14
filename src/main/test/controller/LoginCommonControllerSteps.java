package controller;

import RemoteNote.controller.LoginCommonController;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

public class LoginCommonControllerSteps extends Steps {
    private String sLogin;
    private String sResult;

    @Given("a string, $stringValue")
    public void setStringName(@Named("$stringValue")String stringValue){
        sLogin = stringValue;
    }

    @When("the caller send string in controller")
    public void sendString() {
        LoginCommonController commonController = new LoginCommonController();
        sResult = commonController.authorizeUser(sLogin);
        System.out.println(sResult+" "+ sLogin);
    }

    @Then("the controller is returned a null, because connection with db not allowed")
    public void checkResultString(){
        Assert.assertTrue("result must be empty",
                sResult.equals("{}"));
    }
}
