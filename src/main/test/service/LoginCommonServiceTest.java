package service;

import RemoteNote.model.User;
import RemoteNote.service.LoginCommonService;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
        jsonObject.put("password", "admin");
        User user = new User();
        user.setFullName("admin");
        when(lcsMock.authUser(jsonObject)).thenReturn(user);
        Assert.assertEquals("admin", lcsMock.authUser(jsonObject).getFullName());
    }

    @Test(expected = RuntimeException.class)
    public void authUser_json_nullReturned() throws SQLException {
        LoginCommonService lcsMock = mock(LoginCommonService.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("password", java.util.Optional.of(null));
        User user = new User();
        user.setFullName("admin");
        when(lcsMock.authUser(jsonObject)).thenReturn(user);
        Assert.assertEquals("admin", lcsMock.authUser(jsonObject).getFullName());
    }

    @Test(expected = RuntimeException.class)
    public void authUser_json_nullUserReturned() throws SQLException {
        LoginCommonService lcsMock = mock(LoginCommonService.class);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("password", "admin");
        User user = null;
        when(lcsMock.authUser(jsonObject)).thenReturn(user);
        Assert.assertEquals("admin", lcsMock.authUser(jsonObject).getFullName());
    }

}
