package dao;

import entity.*;

import generate.MyGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.sql.Array;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {


//        Logger logger = LoggerFactory.getLogger(Main.class);
//        logger.info("This is how you configure Java Logging with SLF4J");
//
//
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");

//сейчас ничего нет
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//прочитало конфиг. там создало dataSource и template и поместило в контейнер
        // MyGenerator gen = new MyGenerator();
        ArrayList<FeaturesType> features = new ArrayList();
        features.add(FeaturesType.BALCONY);
        features.add(FeaturesType.TV);
        Hotel hoteln = new Hotel(2, "rabotaet", 5, "vseokeushki", 32.3f, -32.0f, features);

        HotelDaoImpl userTesr = ctx.getBean(HotelDaoImpl.class);


        userTesr.updateHotel(hoteln);

    }
}



