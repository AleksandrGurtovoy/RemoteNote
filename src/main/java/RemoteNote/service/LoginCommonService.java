package RemoteNote.service;

import RemoteNote.model.DaoException;
import RemoteNote.model.User;
import RemoteNote.model.UserDao;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.sql.SQLException;
import java.util.Objects;

@Service
public class LoginCommonService {

    private static final Logger LOG = Logger.getLogger(LoginCommonService.class);

    @Autowired
    private UserDao userDao;

    public JSONObject authUser(String login) throws SQLException {
        LOG.info("authUser started...");
        JSONObject jsonObject = new JSONObject();
        if (Objects.isNull(login)) {
            throw new ServiceException("Login is null");
        }
        User user;
        try {
            user = userDao.getUserByLogin(login);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        if (Objects.isNull(user)) {
            throw new SerialException("User with login = " + login + " not found");
        }
        jsonObject.put("login", user.getLogin());
        jsonObject.put("fullName", user.getFullName());
        jsonObject.put("password", user.getPassword());
        return jsonObject;
    }
}

