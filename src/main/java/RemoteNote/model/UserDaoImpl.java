package RemoteNote.model;

import RemoteNote.db.DBConnectionImpl;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String login, String password) throws SQLException {
        DBConnectionImpl connection = new DBConnectionImpl();
        return connection.getUser(login, password);
    }
}
