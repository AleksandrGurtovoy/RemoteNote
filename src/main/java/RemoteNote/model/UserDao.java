package RemoteNote.model;

import org.springframework.web.multipart.MultipartFile;

public interface UserDao {
    User getUser(String login, String password);

    User getUserByLogin(String login);

    byte[] getPhotoByLogin(String login);

    void setPhotoByLogin(String login, byte[] photo);
}
