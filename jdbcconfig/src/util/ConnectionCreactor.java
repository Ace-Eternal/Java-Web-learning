package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreactor {
    public Connection createconn(){
        Connection connection= null;
        try {
            connection = DriverManager.getConnection(ConfigManager.getProp("DBurl"),ConfigManager.getProp("name"),ConfigManager.getProp("pwd"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
