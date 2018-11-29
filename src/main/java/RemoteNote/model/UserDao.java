package RemoteNote.model;

public interface UserDao {
    User getUser(String login, String password);

    User getUserByLogin(String login);

    Boolean saveUserData(String login, String fullName, String date);
}
