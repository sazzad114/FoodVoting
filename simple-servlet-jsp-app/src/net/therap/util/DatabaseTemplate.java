package net.therap.util;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sazzadur
 * Date: 4/9/12
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseTemplate {

    private Connection connection;


    public void openConnection() {
        Context initContext = null;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
            connection = ds.getConnection();
        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void execute(String query) {
        openConnection();
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeQuery(query);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                stmt.close();
                closeConnection();
            } catch (NullPointerException e) {
                closeConnection();
                throw new RuntimeException(e);
            } catch (SQLException e) {
                closeConnection();
                throw new RuntimeException(e);
            }
        }
    }

    public <E> List<E> queryForObject(RowObjectMapper<E> rowObjectMapper, String query, Object... parameters) {

        openConnection();
        List<E> listOfE = new ArrayList<E>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof String) {
                    preparedStatement.setString(i, (String) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(i, (Integer) parameter);
                } else if (parameter instanceof Long) {
                    preparedStatement.setLong(i, (Long) parameter);
                } else if (parameter instanceof Date)
                    preparedStatement.setDate(i, new java.sql.Date(1000) );
                i++;
            }

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                listOfE.add(rowObjectMapper.mapRowToObject(resultSet));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {
                resultSet.close();
                preparedStatement.close();
                closeConnection();
            } catch (NullPointerException e) {
                closeConnection();
                throw new RuntimeException(e);
            } catch (SQLException e) {
                closeConnection();
                throw new RuntimeException(e);
            }


        }
        return listOfE;
    }

    public void executeInsertQuery(String query, Object... parameters) {
        openConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object parameter : parameters) {
                if (parameter instanceof String) {
                    preparedStatement.setString(i, (String) parameter);
                } else if (parameter instanceof Integer) {
                    preparedStatement.setInt(i, (Integer) parameter);
                } else if (parameter instanceof Long) {
                    preparedStatement.setLong(i, (Long) parameter);
                }
                i++;
            }

            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {

            try {

                preparedStatement.close();
                closeConnection();
            } catch (NullPointerException e) {
                closeConnection();
                throw new RuntimeException(e);
            } catch (SQLException e) {
                closeConnection();
                throw new RuntimeException(e);
            }
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
