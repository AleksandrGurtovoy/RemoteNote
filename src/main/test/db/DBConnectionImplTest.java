package db;

import RemoteNote.db.DBConnection;
import RemoteNote.db.DBConnectionImpl;
import RemoteNote.model.User;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DBConnectionImplTest {

    @Test
    public void getConnection_null() throws SQLException {
        DBConnectionImpl connection = mock(DBConnectionImpl.class);
        Connection conn = null;
        when(connection.getConnection()).thenReturn(conn);
        Assert.assertEquals(null, connection.getConnection());
    }

    @Test
    public void getUserByLogin_string_ok() throws SQLException {
        DBConnectionImpl connection = mock(DBConnectionImpl.class);
        User user = new User();
        user.setFullName("Test");
        when(connection.getUserByLogin(anyString())).thenReturn(user);
        Assert.assertEquals("Test", connection.getUserByLogin("login").getFullName());
    }
}
