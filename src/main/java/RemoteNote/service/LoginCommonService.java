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
    private UserDao userDao;

    public JSONObject authUser(String login) throws SQLException {
        JSONObject jsonObject = new JSONObject();
        User user = new User();
        if (login != null) {
            user = userDao.getUserByLogin(login);
        } else {
            throw new RuntimeException("Login is null");
        }
        if (!Objects.isNull(user)) {
            jsonObject.put("login", user.getLogin());
            jsonObject.put("fullName", user.getFullName());
            jsonObject.put("password", user.getPassword());
            return jsonObject;
        } else {
            throw new RuntimeException("User with login = " + login + " not found");
        }
    }

}
