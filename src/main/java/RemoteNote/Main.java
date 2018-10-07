package RemoteNote;

import RemoteNote.controller.LoginCommonController;
import RemoteNote.db.DBConnection;
import RemoteNote.model.User;
import RemoteNote.service.LoginCommonService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Main {




    public static void main(String[] args) throws Exception {
        login();
    }

    public static void login() throws Exception {
        LoginCommonController loginCommonController = new LoginCommonController();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("login", "admin");
        jsonObject.put("password", "admin");
        User user = loginCommonController.authorizeUser(jsonObject);
        System.out.println(user.getFullName());
        /*Properties props = new Properties();
        props.setProperty("user","postgres");
        props.setProperty("password", "root");
        String url = "jdbc:postgresql://localhost/RemoteNote";
        Connection conn = DriverManager.getConnection(url, props);
        PreparedStatement statement = conn.prepareStatement("select * from \"Users\" where login = ? and password = ?");
        statement.setString(1, "admin");
        statement.setString(2, "admin");
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        while (resultSet.next()){
            user.setFullName(resultSet.getString("FullName"));
        }

        System.out.println(user.getFullName());
        System.out.println("ok");*/
    }
}
