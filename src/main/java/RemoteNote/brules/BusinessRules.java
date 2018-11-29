package RemoteNote.brules;

import RemoteNote.model.*;
import RemoteNote.service.ServiceException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BusinessRules {


    private UserDaoImpl userDao = new UserDaoImpl();
    private NoteDaoImpl noteDao = new NoteDaoImpl();

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

    public Boolean saveUserData(String login, String fullName, String date) {
        if (Objects.isNull(fullName)) {
            fullName = "";
        }
        if (Objects.isNull(date)) {
            date = "";
        }
        if (Objects.isNull(login)) {
            throw new RuntimeException("Login must be not null");
        }
        Boolean result = false;
        try {
            result = userDao.saveUserData(login, fullName, date);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        return result;
    }

    public List<Note> getNotesByLogin(String login) {
        if (Objects.isNull(login)) {
            throw new RuntimeException("Login must be not null");
        }
        List<Note> notes = new ArrayList<>();
        try {
            notes = noteDao.getNotesByLogin(login);
        } catch (DaoException ex) {
            throw new ServiceException(ex, ex.getMessage());
        }
        return notes;
    }

}
