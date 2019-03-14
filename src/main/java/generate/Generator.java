package generate;

import com.github.javafaker.Faker;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import java.sql.SQLException;

public class Generator {

    public static void main(String[] args) {

//        public void generateHotels (){
        Faker faker = new Faker();

            String name = faker.company().name();
           int stars = (int) ((Math.random() * 5)+1);




           Fairy fairy = Fairy.create();
        Person person = fairy.person();
        System.out.println(fairy.company().getName());

//
    }
}
