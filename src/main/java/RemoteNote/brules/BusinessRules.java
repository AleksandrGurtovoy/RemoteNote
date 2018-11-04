package RemoteNote.brules;

import RemoteNote.model.DaoException;
import RemoteNote.model.User;
import RemoteNote.model.UserDaoImpl;
import RemoteNote.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Objects;
@Service
public class BusinessRules {


    private UserDaoImpl userDao = new UserDaoImpl();

    public User getUser(String login) {
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
            throw new RuntimeException("User with login = " + login + " not found");
        }
        return user;
    }
}
