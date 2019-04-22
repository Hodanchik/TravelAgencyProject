import dao.HotelDao;
import dao.TourDao;
import dao.UserDao;
import dao.huinya.AppConfig;
import dao.impls.HotelDaoImpl;
import dao.impls.TourDaoImpl;
import dao.impls.UserDaoImpl;
import entity.*;

import generate.MyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.*;
import service.impls.HotelServiceImpl;
import service.impls.ReviewServiceImpl;
import service.impls.TourServiceImpl;
import service.impls.UserServiceImpl;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {


       Logger logger = LoggerFactory.getLogger(Main.class);
       logger.info("This is how you configure Java Logging with SLF4J");


//        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        HotelDao service = ctx.getBean(HotelDaoImpl.class);
//        Hotel hotelById = service.getHotelById(6);
//
//        System.out.println(hotelById);

//        TourDao tourTesr = ctx.getBean(TourDaoImpl.class);
////        Tour tour = new Tour("PhotoForProject/cinque-terre-340348_960_720.jpg",
////                LocalDate.of(2019,11,20), 4, "good tour for you", 450, TourType.TRAINING, 6, 19);
//        Tour tour = new Tour("PhotoForProject/cinque-terre-340348_960_720.jpg",
//                LocalDate.of(2019,11,20), 4, "good tour for you", 450, TourType.TRAINING, 6, 19 );
//
//        tourTesr.addTour(tour);
//        tour.setPhoto("YHAHAHAHA");
//  tourTesr.updateTour(tour);




    }
}





