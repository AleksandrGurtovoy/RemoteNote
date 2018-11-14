package RemoteNote;

import RemoteNote.controller.LoginCommonController;
import RemoteNote.file.MultipartFileImpl;
import RemoteNote.model.User;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.file.Files;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        LoginCommonController loginCommonController = new LoginCommonController();

        File file = new File("E:\\Work\\RemoteNote\\web\\john-travolta-bald.jpg");
        byte[] bytes = FileUtils.readFileToByteArray(file);
        System.out.println(bytes.length);
        byte[] encoded = Base64.getEncoder().encode(bytes);
        System.out.println(new String(encoded));
        byte[] decoded = Base64.getDecoder().decode(encoded);

       // loginCommonController.setPhoto("admin", encoded);
       /* OutputStream os = new FileOutputStream(file);
        InputStream is = new ByteArrayInputStream(bytes);
       os.close();
       is.close();*/
       /* MultipartFile multipartFile = new MultipartFileImpl(bytes," ", "", "");
       loginCommonController.setPhoto("admin", multipartFile);*/

        String login = "admin";/*
        User user = loginCommonController.authorizeUser(login);
        System.out.println(user.getFullName());*/
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
