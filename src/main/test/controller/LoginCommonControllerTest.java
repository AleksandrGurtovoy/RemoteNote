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
        User testUser = new User();
        testUser.setFullName("admin");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("password", "admin");
        when(lccMock.authorizeUser(jsonObject)).thenReturn(testUser);
        Assert.assertEquals("admin", lccMock.authorizeUser(jsonObject).getFullName());
    }

    @Test
    public void authorizeUser_json_falseReturned() throws Exception {
        LoginCommonController lccMock = mock(LoginCommonController.class);
        User testUser = new User();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "propro");
        jsonObject.put("password", "propro");
        when(lccMock.authorizeUser(jsonObject)).thenReturn(testUser);
        Assert.assertEquals(null, lccMock.authorizeUser(jsonObject).getFullName());
    }
}
