package RemoteNote.model;

import RemoteNote.db.DBConnectionImpl;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String login, String password) {
        DBConnectionImpl connection = new DBConnectionImpl();
        User user;
        try {
            user = connection.getUser(login, password);
        } catch (DaoException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        DBConnectionImpl connection = new DBConnectionImpl();
        User user;
        try {
            user = connection.getUserByLogin(login);
        } catch (DaoException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
        return user;
    }
}
