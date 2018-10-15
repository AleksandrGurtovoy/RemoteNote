package RemoteNote.service;

import RemoteNote.model.User;
import RemoteNote.model.UserDaoImpl;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Objects;

@Service
public class LoginCommonService {

    private UserDaoImpl userDao = new UserDaoImpl();

    public User authUser(JSONObject params) throws SQLException {
        String login = params.getString("login");
        String pass = params.getString("password");

        User user = new User();
        if (login != null && pass != null) {
            user = userDao.getUser(login, pass);
        } else {
            throw new RuntimeException("Login or pass is null");
        }
        if (!Objects.isNull(user)) {
            return user;
        } else {
            throw new RuntimeException("User with login = " + login + " not found");
        }
    }

}
