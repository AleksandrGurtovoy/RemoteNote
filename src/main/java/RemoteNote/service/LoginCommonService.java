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

    public User authUser(String login) throws SQLException {

        User user = new User();
        if (login != null) {
            user = userDao.getUserByLogin(login);
        } else {
            throw new RuntimeException("Login is null");
        }
        if (!Objects.isNull(user)) {
            return user;
        } else {
            throw new RuntimeException("User with login = " + login + " not found");
        }
    }

}
