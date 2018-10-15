package RemoteNote;

import RemoteNote.controller.LoginCommonController;
import RemoteNote.model.User;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {
        LoginCommonController loginCommonController = new LoginCommonController();

        String login = "admin";
        User user = loginCommonController.authorizeUser(login);
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
