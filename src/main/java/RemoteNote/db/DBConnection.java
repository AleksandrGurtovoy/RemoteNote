package RemoteNote.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class DBConnection {

    protected Connection getConnection() throws SQLException {
        HashMap<String, String> info = getInfo();
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);
        return DriverManager.getConnection(info.get("url"), info.get("user"), info.get("password"));
    }

    private HashMap<String, String> getInfo() {
        HashMap<String, String> info = new HashMap<>();
        Properties properties = getProperties("DBInfo.properties");
        info.put("url", properties.getProperty("jdbc.url"));
        info.put("user", properties.getProperty("jdbc.user"));
        info.put("password", properties.getProperty("jdbc.password"));
        return info;
    }

    private Properties getProperties(String fileName) {
        Properties properties = null;
        try (InputStream inputStream = new FileInputStream("src/main/resources/db/" + fileName)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    protected String getQuery(String nameQuery) {
        Properties properties = getProperties("sql.properties");
        return properties.getProperty(nameQuery);
    }
}
