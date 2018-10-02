package RemoteNote.service;

import RemoteNote.model.UserDao;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginCommonService {

    @Autowired
    UserDao userDao;

    public boolean authUser(JSONObject params) {
        String login = params.getString("login");
        String pass = params.getString("password");

        /*User user = new User();
        if (login != null && pass != null){
            user = userDao.findByLoginAndPass(login, pass);
        }*/
        if ("admin".equals(login) && "admin".equals(pass)) {
            return true;
        } else {
            throw new RuntimeException("Login or password is incorrect");
        }
    }

}
