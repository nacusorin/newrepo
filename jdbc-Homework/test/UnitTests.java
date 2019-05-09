import org.junit.Test;

import java.sql.*;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static ro.sci.g14.jdbc.ConnectionManager.getConnection;


public class UnitTests {

    @Test
    public void insertDataTest() throws SQLException {
        Connection connection = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement1 = connection.prepareStatement("insert into accomodation_test values(?,?,?,?,?)");
            preparedStatement1.setInt(1, 1);
            preparedStatement1.setString(2, "single");
            preparedStatement1.setString(3, "small size");
            preparedStatement1.setInt(4, 1);
            preparedStatement1.setString(5, "room for one");

            preparedStatement1.executeUpdate();
            preparedStatement1.close();

            PreparedStatement prd1 = connection.prepareStatement("select * from accomodation_test");
            ResultSet rs1 = prd1.executeQuery();

            while (rs1.next()) {

                assertEquals(1, rs1.getInt(1));
                assertEquals("sinlge", rs1.getString(2));
                assertEquals("small size", rs1.getString(3));
                assertEquals(1, rs1.getInt(4));
                assertEquals("room for one", rs1.getString(5));

            }
            rs1.close();
            prd1.close();

            PreparedStatement preparedStatementt = connection.prepareStatement("insert into room_fair_test values(?,?,?)");

            preparedStatementt.setInt(1, 1);
            preparedStatementt.setInt(2, 15);
            preparedStatementt.setString(3, "summer");
            preparedStatementt.executeUpdate();
            preparedStatementt.close();

            PreparedStatement prd = connection.prepareStatement("select * from room_fair_test");
            ResultSet rs = prd.executeQuery();

            while (rs.next()) {
                assertEquals(1, rs.getInt(1));
                assertEquals(15, rs.getInt(2));
                assertEquals("summer", rs.getString(3));

            }
            rs.close();
            prd.close();

            PreparedStatement preparedStatement3 = connection.prepareStatement("insert into accomodation_fair_relation_test values(?,?,?)");

            preparedStatement3.setInt(1, 1);
            preparedStatement3.setInt(2, 1);
            preparedStatement3.setInt(3, 1);
            preparedStatement3.executeUpdate();
            preparedStatement3.close();

            PreparedStatement prd3 = connection.prepareStatement("select * from accomodation_fair_relation_test");
            ResultSet rs3 = prd3.executeQuery();

            while (rs3.next()) {
                assertEquals(1, rs3.getInt(1));
                assertEquals(1, rs3.getInt(2));
                assertEquals(1, rs3.getInt(3));

            }
            rs3.close();
            prd3.close();

        } catch (SQLException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        } finally {
            connection.rollback();
            connection.close();
        }
    }

    @Test
    public void selectFromTableTest() throws SQLException {

        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            DriverManager.setLoginTimeout(60);
            String url = new StringBuilder()
                    .append("jdbc:")
                    .append("postgresql")       // “mysql” / “db2” / “mssql” / “oracle” / ...
                    .append("://")
                    .append("localhost")
                    .append(":")
                    .append(5432)
                    .append("/")
                    .append("postgres")
                    .append("?currentSchema=")
                    .append("sci2")
                    .append("&user=")
                    .append("postgres")
                    .append("&password=")
                    .append("72629609Lorena").toString();

            System.out.println("url: " + url);
            connection = DriverManager.getConnection(url);

            try {
                PreparedStatement prd = connection.prepareStatement("select * from room_fair where id = 1");
                ResultSet rs = prd.executeQuery();
                final Logger LOGGER = Logger.getLogger(UnitTests.class.getName());

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnNumber = rsmd.getColumnCount();

                while (rs.next()) {
                    assertEquals(1, rs.getInt(1));
                    assertEquals(100, rs.getInt(2));
                    assertEquals("winter", rs.getString(3));

                    for (int i = 1; i <= columnNumber; i++) {
                        String columnValue = rs.getString(i);
                        LOGGER.info(columnValue + " " + rsmd.getColumnName(i));
                    }
                }
                rs.close();
                prd.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            final Logger LOGGER = Logger.getLogger(UnitTests.class.getName());
            PreparedStatement prd1 = connection.prepareStatement("select * from room_fair as rf,accomodation as a,accomodation_fair_relation as afr where rf.id=afr.id_room_fair and a.id=afr.id_accomodation and rf.value=15");
            ResultSet rs1 = prd1.executeQuery();
            ResultSetMetaData rsmd = rs1.getMetaData();
            int columnNumber = rsmd.getColumnCount();
            while (rs1.next()) {

                for (int i = 1; i <= columnNumber; i++) {
                    String columnValue = rs1.getString(i);
                    LOGGER.info(columnValue + " " + rsmd.getColumnName(i));

                }
            }


        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        } finally {
            connection.close();
        }
    }
}