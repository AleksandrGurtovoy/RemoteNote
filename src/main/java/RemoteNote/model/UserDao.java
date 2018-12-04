package RemoteNote.model;

public interface UserDao {
    User getUser(String login, String password);

    User getUserByLogin(String login);

    void saveUserData(String login, String fullName, String date);

    String getPhotoByLogin(String login);

    void setPhotoByLogin(String login, String photo);
}
