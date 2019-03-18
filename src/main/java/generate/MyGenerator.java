package generate;

import de.svenjacobs.loremipsum.LoremIpsum;
import entity.FeaturesType;
import entity.Hotel;
import entity.Tour;
import entity.TourType;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;
import me.xdrop.jrand.JRand;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MyGenerator {
    List<String> photos = readFiles();
    public static void main(String[] args) throws ParseException, IOException {
        MyGenerator gen = new MyGenerator();

    gen.generateTour();
    }

    public Hotel generateHotels() {

        int stars = (int) ((Math.random() * 5) + 1);
        Company com = Fairy.create().company();
        String name = com.getName();
        String url = com.getUrl();
        float lalitude = Float.valueOf(JRand.latitude().gen());
        float longitude = Float.valueOf(JRand.longitude().gen());
            FeaturesType[] features = new FeaturesType[(int) ((Math.random() * 10)+1)];
        for (int i = 0; i < features.length; i++) {
            features[i] = FeaturesType.getRandomType();
        }
        List<FeaturesType> featuress = new ArrayList<>();
        for (int i = 0; i < features.length; i++){
            featuress.add(features[i]);
        }
        return new Hotel(name, stars, url, lalitude, longitude, featuress);
    }

        public Tour generateTour () {

            String photo = photos.get(new Random().nextInt(photos.size()));

            LocalDate from = LocalDate.of(2019, 1, 1);
            LocalDate to = LocalDate.of(2020, 1, 1);
            long days = from.until(to, ChronoUnit.DAYS);
            long randomDays = ThreadLocalRandom.current().nextLong(days);
            LocalDate randomDate = from.plusDays(randomDays);
            System.out.println(randomDate);

            int duration = (int) ((Math.random() * 14) + 2);


            LoremIpsum loremIpsum = new LoremIpsum();
            String description = loremIpsum.getWords(new Random().nextInt(15), new Random().nextInt(20));

            int cost = (int) ((Math.random() * 800) + 200);



            TourType tourtype = TourType.getRandomType();


            int hotel_id = (int) ((Math.random() * 100) + 1);

            int country_id = (int) ((Math.random() * 75) + 1);


            Tour tour = new Tour(photo, randomDate, duration, description, cost, tourtype, hotel_id, country_id);
            System.out.println(tour);
            return tour;


        }

        public List<String> readFiles () {
            String zipFileName = "C:\\Users\\Tank\\IdeaProjects\\TravelAgencyProject\\src\\main\\resources\\Photos";
            List<String> photos = new ArrayList<>();
            Path path1 = Paths.get(zipFileName);

            try (Stream<Path> paths = Files.walk(path1)) {
                paths
                        .filter(path -> Files.isRegularFile(path))
                        .filter(path -> path.toString().endsWith(".jpg"))
                        .forEach(path -> photos.add(path.toString()));

            } catch (IOException e) {
                e.printStackTrace();
            }
            return photos;
        }


    }

