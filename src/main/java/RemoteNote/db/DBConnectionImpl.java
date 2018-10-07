package RemoteNote.db;

import RemoteNote.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionImpl {

    private static final DBConnection dbconnection = new DBConnection();

    public Connection getConnection() throws SQLException {
        return dbconnection.getConnection();
    }

    public User getUser(String login, String password) throws SQLException {
        User user = new User();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.getQuery("getUser"))) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            user.setLogin(resultSet.getString("login"));
            user.setFullName(resultSet.getString("FullName"));
        }
        return user;
    }

}
