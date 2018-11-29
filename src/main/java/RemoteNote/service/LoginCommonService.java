package RemoteNote.service;

import RemoteNote.brules.BusinessRules;
import RemoteNote.model.User;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service("loginCommonService")
public class LoginCommonService {

    private BusinessRules brules = new BusinessRules();

    private static final Logger LOG = Logger.getLogger(LoginCommonService.class);


    public JSONObject authUser(String login) {
        LOG.info("authUser started...");
        JSONObject jsonObject = new JSONObject();
        User user = brules.getUser(login);
        jsonObject.put("login", user.getLogin());
        jsonObject.put("fullName", user.getFullName());
        jsonObject.put("password", user.getPassword());
        return jsonObject;
    }

    public Boolean saveUserData(String login, String fullName, String date) {
        LOG.info("saving user data started...");
        return brules.saveUserData(login, fullName, date);
    }

}

