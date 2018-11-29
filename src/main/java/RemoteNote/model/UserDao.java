package RemoteNote.model;

import org.springframework.web.multipart.MultipartFile;

public interface UserDao {
    User getUser(String login, String password);

    User getUserByLogin(String login);

    Boolean saveUserData(String login, String fullName, String date);

    String getPhotoByLogin(String login);

    void setPhotoByLogin(String login, String photo);
}
