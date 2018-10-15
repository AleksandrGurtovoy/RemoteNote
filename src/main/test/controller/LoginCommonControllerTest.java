package controller;

import RemoteNote.controller.LoginCommonController;
import RemoteNote.model.User;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommonControllerTest {

    @Test
    public void authorizeUser_json_trueReturned() throws Exception {
        LoginCommonController lccMock = mock(LoginCommonController.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("fullName", "admin");
        jsonObject.put("password","admin");
        String login = "admin";
        when(lccMock.authorizeUser(login)).thenReturn(jsonObject.toString());
        Assert.assertEquals(jsonObject.toString(), lccMock.authorizeUser(login));
    }

    @Test
    public void mainPage_indexReturned(){
        LoginCommonController controller = new LoginCommonController();
        String result = controller.mainPage();
        Assert.assertEquals("index", result);
    }
}
