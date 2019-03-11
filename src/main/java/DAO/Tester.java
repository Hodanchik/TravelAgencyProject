package DAO;

import Entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    static String SQL_QUERY = "SELECT id, login, password\n" +
            "\tFROM public.users;";
    static String INSERT_TO_COUNTRY = "INSERT INTO public.\"Country\"(name)\n" +
            "\tVALUES (?)";



    public static void  addToCountry (List<String> countries) throws SQLException {
        try (Connection con = DataSource.getConnection();
            PreparedStatement pst = con.prepareStatement(INSERT_TO_COUNTRY)) {
                for (int i = 0; i < countries.size(); i++) {
                    pst.setString(1, countries.get(i));
                    boolean executed = pst.execute();
                }
            }
        }




    public static List<User> fetchData() throws SQLException {




        List<User> users = null;
        try (Connection con = DataSource.getConnection();
             PreparedStatement pst = con.prepareStatement( SQL_QUERY );
             ResultSet rs = pst.executeQuery();) {
            users = new ArrayList<>();
            User user;
            while ( rs.next() ) {
                user = new User();
                user.setId( rs.getInt( "id" ) );
                user.setLogin( rs.getString( "login" ) );
                user.setPassword( rs.getString( "password" ) );
                users.add( user );
            }
        }
        return users;
    }

}
