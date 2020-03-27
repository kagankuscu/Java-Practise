package org.paumard.reflection.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.paumard.reflection.annotation.Provides;

/**
 * H2ConnectionProvider
 */
public class H2ConnectionProvider {
    @Provides
    public Connection buildConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(
             "jdbc:h2:E:\\Java Programming Language\\Java-Practise\\Java Console App\\Dependecy Injection\\db-files\\db-pluralsight",
              "sa", "");
              
        return connection;
    }
}