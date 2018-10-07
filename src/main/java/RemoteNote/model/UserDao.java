package RemoteNote.model;

import org.springframework.stereotype.Component;

import java.sql.SQLException;
@Component
public interface UserDao {
    User getUser(String login, String password) throws SQLException;
}
