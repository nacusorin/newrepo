package ro.sci.g14.jdbc;

import java.sql.*;

public class AccomodationService implements SciService {

    private Connection connection;

    public AccomodationService(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void listAll() throws SQLException {
        Statement s = connection.createStatement();

        ResultSet resultSet = s.executeQuery("SELECT * from accomodation");
        while (resultSet.next()) {
            Accomodation accomodation = getAccomodation(resultSet);

            System.out.println(accomodation.toString());
        }
        resultSet.close();
    }




    public Accomodation getAccomodation(ResultSet resultSet) throws SQLException {
        Accomodation accomodation = new Accomodation();
        accomodation.setId(resultSet.getInt("id") );
        accomodation.setType(resultSet.getString("type"));
        accomodation.setBedType(resultSet.getString("bed_type"));
        accomodation.setMaxGuests(resultSet.getInt("max_guests"));
        accomodation.setDescription(resultSet.getString("description"));
        return accomodation;
    }

}
