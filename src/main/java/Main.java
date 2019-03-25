import dao.UserDao;
import dao.huinya.AppConfig;
import dao.impls.UserDaoImpl;
import entity.*;

import generate.MyGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ReviewService;
import service.TourService;
import service.UserService;
import service.impls.ReviewServiceImpl;
import service.impls.TourServiceImpl;
import service.impls.UserServiceImpl;


import java.sql.SQLException;

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
      //  User iser = new User();
    UserDao userTesr = ctx.getBean(UserDaoImpl.class);
    UserDaoImpl userTer = ctx.getBean(UserDaoImpl.class);

        User userById = userTer.getUserById(5);
        System.out.println( userById);
}
    }





