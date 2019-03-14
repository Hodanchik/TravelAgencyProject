package dao;

import entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {


//        Logger logger = LoggerFactory.getLogger(Main.class);
//        logger.info("This is how you configure Java Logging with SLF4J");
//
//
//        ApplicationContext context = new ClassPathXmlApplicationContext(
//                "applicationContext.xml");


        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] mas = ctx.getBeanDefinitionNames();

        for (String one : mas) {
            System.out.println(one);
        }
        User usern = new User("lapa", "shara32");

        UserDaoImpl userTesr = new UserDaoImpl();

        userTesr.addUser(usern);


    }
}


