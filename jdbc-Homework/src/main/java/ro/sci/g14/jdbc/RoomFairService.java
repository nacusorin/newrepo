package ro.sci.g14.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RoomFairService implements SciService {

    private Connection connection;

    public RoomFairService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void listAll() throws SQLException {
        Statement s = connection.createStatement();

        ResultSet resultSet = s.executeQuery("SELECT * from room_fair");
        while (resultSet.next()) {
            RoomFair roomFair = getRoomFair(resultSet);

            System.out.println(roomFair.toString());
        }
        resultSet.close();
        s.close();
    }

    private RoomFair getRoomFair(ResultSet resultSet) throws SQLException {
        RoomFair roomFair = new RoomFair();
        roomFair.setId(resultSet.getInt("id"));
        roomFair.setValue(resultSet.getDouble("value"));
        roomFair.setSeason(resultSet.getString("season"));
        return roomFair;
    }

}
