package RemoteNote.model;

import java.sql.SQLException;

public interface UserDao {
    public User getUser(String login, String password) throws SQLException;
}
