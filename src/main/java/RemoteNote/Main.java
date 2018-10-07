package RemoteNote;

import RemoteNote.controller.LoginCommonController;
import RemoteNote.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class Main {
    @Autowired
    static LoginCommonController loginCommonController;

    public static void main(String[] args) throws Exception {
        login();
    }

    public static void login() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("password", "admin");
        User user = loginCommonController.authorizeUser(jsonObject);
        System.out.println(user.getFullName());
    }
}
