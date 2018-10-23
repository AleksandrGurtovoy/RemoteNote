package RemoteNote.model;

import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    User getUser(String login, String password);

    User getUserByLogin(String login);
}
