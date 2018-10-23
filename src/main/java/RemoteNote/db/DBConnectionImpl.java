package RemoteNote.db;

import RemoteNote.model.DaoException;
import RemoteNote.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class DBConnectionImpl {
    private static final Logger LOG = Logger.getLogger(DBConnectionImpl.class);
    private static final DBConnection dbconnection = new DBConnection();

    public Connection getConnection() throws SQLException {
        return dbconnection.getConnection();
    }

    public User getUser(String login, String password) {
        LOG.info("DBConnectionImpl, getUser with login " + login + "started...");
        User user = new User();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.getQuery("getUser"))) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
                user.setFullName(resultSet.getString("FullName"));
            }
        } catch (SQLException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
        return user;
    }

    public User getUserByLogin(String login) {
        LOG.info("DBConnectionImpl, getUserByLogin with login " + login + "started...");
        User user = new User();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(dbconnection.getQuery("getUserByLogin"))) {
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user.setLogin(resultSet.getString("login"));
                user.setFullName(resultSet.getString("FullName"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException ex) {
            throw new DaoException(ex, ex.getMessage());
        }
        return user;
    }

}
