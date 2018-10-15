package service;

import RemoteNote.model.User;
import RemoteNote.service.LoginCommonService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginCommonServiceTest {

    @Test
    public void authUser_json_userReturned() throws SQLException {
        LoginCommonService lcsMock = mock(LoginCommonService.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("fullName", "admin");
        jsonObject.put("password","admin");
        String login = "login";
        when(lcsMock.authUser(login)).thenReturn(jsonObject);
        Assert.assertEquals("admin", lcsMock.authUser(login).get("fullName"));
    }

    @Test(expected = RuntimeException.class)
    public void authUser_json_nullUserReturned() throws SQLException {
        LoginCommonService lcsMock = mock(LoginCommonService.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("fullName", java.util.Optional.of(null));
        jsonObject.put("password","admin");
        String login = "login";
        User user = null;
        when(lcsMock.authUser(login)).thenReturn(jsonObject);
        Assert.assertEquals("admin", lcsMock.authUser(login).get("fullName"));
    }

}
