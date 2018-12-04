package RemoteNote.service;

import RemoteNote.brules.BusinessRules;
import RemoteNote.model.User;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;

@Service("loginCommonService")
public class LoginCommonService {

    private BusinessRules brules = new BusinessRules();

    private static final Logger LOG = LoggerFactory.getLogger(LoginCommonService.class);


    public JSONObject authUser(String login) {
        LOG.info("authUser started...");
        JSONObject jsonObject = new JSONObject();
        User user = brules.getUser(login);
        jsonObject.put("login", user.getLogin());
        jsonObject.put("fullName", user.getFullName());
        jsonObject.put("password", user.getPassword());
        jsonObject.put("dateOfBirthday", user.getDateOfBirthday());
        jsonObject.put("student", user.getStudent());
        jsonObject.put("id", user.getId());
        return jsonObject;
    }

    public void saveUserData(String login, String fullName, String date) {
        LOG.info("saving user data started...");
         brules.saveUserData(login, fullName, date);
    }


    public String getPhoto(String login) {
        LOG.info("Get photo by login {} is started...", login);
        String photo = brules.getPhoto(login);
        //return Base64.getDecoder().decode(photo.getBytes());
        return photo;
    }

    public String setPhoto(String login, byte[] photo) throws IOException {
        LOG.info("Set photo by login {} is started...", login);
        String encodedPhoto = new String(Base64.getEncoder().encode(photo));
        return brules.setPhoto(login, encodedPhoto);
    }
}

