package DAO;

import Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws SQLException {


        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("This is how you configure Java Logging with SLF4J");


        Tester test = new Tester();
        List<User> users = test.fetchData();
        System.out.println(users.toString());

        List<String> countries = new ArrayList<>();


        String[] isoCountries = Locale.getISOCountries();
        for (int i = 0; i < 25; i++) {


            Locale locale = new Locale("en", isoCountries[i]);

            String name = locale.getDisplayCountry();
            countries.add(name);
        }
        test.addToCountry(countries);

        for (String country : countries) {
            System.out.println(country);
        }
    }


}
