package ro.sci.g14.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccomodationFairRelationService implements SciService{


        private Connection connection;

        public AccomodationFairRelationService(Connection connection) {
            this.connection = connection;
        }


        public void listAll() throws SQLException {
            Statement s = connection.createStatement();

            ResultSet resultSet = s.executeQuery("SELECT * from accomodation_fair_relation");
            while (resultSet.next()) {
                AccomodationFairRelation afr = getAccomodationFairRelation(resultSet);

                System.out.println(afr.toString());
            }
            resultSet.close();
        }




        public AccomodationFairRelation getAccomodationFairRelation(ResultSet resultSet) throws SQLException {
            AccomodationFairRelation accomodationFairRelation = new AccomodationFairRelation();
            accomodationFairRelation.setId(resultSet.getInt("id") );
            accomodationFairRelation.setIdAccomodation(resultSet.getInt("id_accomodation") );
            accomodationFairRelation.setIdRoomFair(resultSet.getInt("id_room_fair") );
            return accomodationFairRelation;
        }

    }