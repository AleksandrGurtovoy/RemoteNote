package RemoteNote.service;

import RemoteNote.model.User;
import RemoteNote.model.UserDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Objects;

@Service
public class LoginCommonService {

    @Autowired
    UserDao userDao;

    public User authUser(JSONObject params) throws SQLException {
        String login = params.getString("login");
        String pass = params.getString("password");

        User user = new User();
        if (login != null && pass != null) {
            user = userDao.getUser(login, pass);
        }
        if (!Objects.isNull(user)) {
            return user;
        } else {
            throw new RuntimeException("User with login = " + login + " not found");
        }
    }

}
