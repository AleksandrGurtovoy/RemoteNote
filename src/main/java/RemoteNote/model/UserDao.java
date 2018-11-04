package RemoteNote.model;

public interface UserDao {
    User getUser(String login, String password);

    User getUserByLogin(String login);
}
